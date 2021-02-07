package com.epam.jwd.decorator;

import com.epam.jwd.Factory.Factory;
import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigurePostProcessorLogger;
import com.epam.jwd.service.impl.FigureExistencePostProcessorLogger;

import java.util.List;

public class LogPostProcessorDecorator implements Factory {

    private final Factory factory;
    private final static FigurePostProcessorLogger figurePostProcessorLog = new FigureExistencePostProcessorLogger();


    public LogPostProcessorDecorator(Factory factory) {
        this.factory = factory;
    }

    @Override
    public Figure createFigure(FigureType figureType, List<Point> points) throws FigureException {
        Figure figure = factory.createFigure(figureType, points);
       figurePostProcessorLog.logPostProcess(figure);
        return figure;
    }
}
