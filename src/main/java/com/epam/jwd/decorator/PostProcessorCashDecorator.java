package com.epam.jwd.decorator;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.Factory;
import com.epam.jwd.model.ConcreteApplicationContext;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;

import java.util.List;

public class PostProcessorCashDecorator extends ConcreteApplicationContext implements Factory {
    private final Factory factory;

    public PostProcessorCashDecorator(Factory factory) {
        this.factory = factory;
    }

    @Override
    public Figure createFigure(FigureType figureType, List<Point> points) throws FigureException {
        Figure figure = factory.createFigure(figureType, points);
        setFigureCash(figure);
        return figure;
    }
}
