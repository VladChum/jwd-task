package com.epam.jwd.model;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.service.FigurePostProcessor;
import com.epam.jwd.service.impl.FigureExistencePostProcessor;

import java.util.List;


public class FigureFactory {

    private final static FigurePostProcessor figurePostProcessor = new FigureExistencePostProcessor();

    public Figure createFigure(FigureType figureType, List<Point> points) throws FigureException {
        Figure figure = null;
        switch (figureType) {
            case LINE:
                figure = new Line(points);
                break;
            case SQUARE:
                figure = new Square(points);
                break;
            case TRIANGLE:
                figure = new Triangle(points);
                break;
            case MULTIANGLE:
                figure = new MultiAngleFigure(points);
                break;
            default:
                throw new FigureNotExistException("Invalid figure type!!!");
        }
        figure = figurePostProcessor.process(figure);
        return figure;
    }
}
