package com.epam.jwd.model;

import com.epam.jwd.Factory.Factory;
import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;

import java.util.List;


public class FigureFactory implements Factory {
    @Override
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
        return figure;
    }
}
