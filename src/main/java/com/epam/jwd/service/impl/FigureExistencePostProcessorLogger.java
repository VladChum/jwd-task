package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.service.FigurePostProcessorLogger;
import org.apache.log4j.Level;

import static com.epam.jwd.app.Main.logger;

public class FigureExistencePostProcessorLogger implements FigurePostProcessorLogger {
    @Override
    public void logPostProcess(Figure figure) throws FigureException {
        logger.log(Level.INFO, "!!!\t" + figure.getFigureType() + "create, Figure ID: " + figure.getId());
        //return figure;
    }
}
