package com.epam.jwd.service;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;

public interface FigurePostProcessorLogger {
    void logPostProcess(Figure figure) throws FigureException;
}
