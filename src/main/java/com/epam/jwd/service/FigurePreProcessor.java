package com.epam.jwd.service;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Point;

import java.util.List;

public interface FigurePreProcessor {
    void preProcess(List<Point> points) throws FigureException;

}
