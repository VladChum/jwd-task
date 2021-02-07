package com.epam.jwd.strategy;

import com.epam.jwd.model.Point;

import java.util.List;

public interface FigurePropertiesStrategy {
    double calculatePerimeter(List<Point> points);
    double calculateArea(List<Point> points);
    boolean exist(List<Point> points);
}
