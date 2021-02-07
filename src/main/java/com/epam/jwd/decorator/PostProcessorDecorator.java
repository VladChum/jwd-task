package com.epam.jwd.decorator;

import com.epam.jwd.factory.Factory;
import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigurePostProcessor;
import com.epam.jwd.service.impl.FigureExistencePostProcessor;

import java.util.List;

public class PostProcessorDecorator implements Factory {

    private final Factory factory;
    private final static FigurePostProcessor figurePostProcessor = new FigureExistencePostProcessor();

    public PostProcessorDecorator(Factory factory) {
        this.factory = factory;
    }

    @Override
    public Figure createFigure(FigureType figureType, List<Point> points) throws FigureException {
        Figure figure = factory.createFigure(figureType, points);
        figurePostProcessor.postProcess(figure);
        return figure;
    }
}
