package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.*;
import com.epam.jwd.service.FigurePostProcessor;

public class FigureExistencePostProcessor implements FigurePostProcessor {
    @Override
    public Figure postProcess(Figure figure) throws FigureException {
        if (figure instanceof Line) {
            figure.setLineStrategy();
            if (!figure.isExist()) {
                throw new FigureNotExistException("Line doesnt not exist!!!");
            }
        } else if (figure instanceof Triangle) {
            figure.setTriangleStrategy();
            if (!figure.isExist()) {
                throw new FigureNotExistException("Triangle doesnt not exist");
            }
        } else if (figure instanceof Square) {
            figure.setSquareStrategy();
            if (!figure.isExist()) {
                throw new FigureNotExistException("Square doesnt not exist");
            }
        } else if (figure instanceof MultiAngleFigure) {
            figure.setMultiAngelFigureStrategy();
            if (!figure.isExist()) {
                throw new FigureNotExistException("MultiAngleFigure doesnt not exist");
            }
        }
        return figure;
    }
}
