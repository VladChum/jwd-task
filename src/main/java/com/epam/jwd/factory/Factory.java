package com.epam.jwd.factory;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;

import java.util.List;

public interface Factory {
        Figure createFigure(FigureType figureType, List<Point> points) throws FigureException;
}
