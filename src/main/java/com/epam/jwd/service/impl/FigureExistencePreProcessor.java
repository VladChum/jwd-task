package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigurePreProcessor;

import java.util.List;

public class FigureExistencePreProcessor implements FigurePreProcessor {
    @Override
    public void preProcess(List<Point> points) throws FigureException {
        for (int i = 0; i < points.size() - 1; i++) {
            for (int j = i + 1; j < points.size(); j++) {
                if (points.get(i).equals(points.get(j))) {
                    throw new FigureNotExistException("Figure with this points can not exist!!!! Points equals");
                }
            }
        }
    }
}
