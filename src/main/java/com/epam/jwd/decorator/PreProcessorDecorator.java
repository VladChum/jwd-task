package com.epam.jwd.decorator;

import com.epam.jwd.factory.Factory;
import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigurePreProcessor;
import com.epam.jwd.service.impl.FigureExistencePreProcessor;

import java.util.List;

public class PreProcessorDecorator implements Factory {

    private final Factory factory;
    private final static FigurePreProcessor figurePreProcessor = new FigureExistencePreProcessor();

    public PreProcessorDecorator(Factory factory) {
        this.factory = factory;
    }

    @Override
    public Figure createFigure(FigureType figureType, List<Point> points) throws FigureException {
        figurePreProcessor.preProcess(points);
        return factory.createFigure(figureType, points);
    }
}
