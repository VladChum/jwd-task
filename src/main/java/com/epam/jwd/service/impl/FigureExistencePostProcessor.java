package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.*;
import com.epam.jwd.service.FigurePostProcessor;

public class FigureExistencePostProcessor implements FigurePostProcessor {
    @Override
    public Figure process(Figure figure) throws FigureException {
        if (figure instanceof Line) {
            figure.setLineStrategy();
            if (!((Line) figure).existLine()) {
                throw new FigureNotExistException("Line doesnt not exist!!!");
            }
        } else if (figure instanceof Triangle) {
            figure.setTriangleStrategy();
            if (!((Triangle) figure).existTriangle()) {
                throw new FigureNotExistException("Triangle doesnt not exist");
            }
        } else if (figure instanceof Square) {
            figure.setSquareStrategy();
            if (!((Square) figure).existSquare()) {
                throw new FigureNotExistException("Square doesnt not exist");
            }
        } else if (figure instanceof MultiAngleFigure) {
            figure.setMultiAngelFigureStrategy();
            if (!((MultiAngleFigure) figure).existMultiAngelFigure()) {
                throw new FigureNotExistException("MultiAngleFigure doesnt not exist");
            }
        }
        return figure;
    }
}
