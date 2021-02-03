package com.epam.jwd.strategy.impl;

import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.FigurePropertiesStrategy;

import java.util.List;

public class LinePropertiesStrategy implements FigurePropertiesStrategy {

    private static LinePropertiesStrategy instance;
    private LinePropertiesStrategy(){}
    public static LinePropertiesStrategy getInstance(){
        if(instance == null){
            instance = new LinePropertiesStrategy();
        }
        return instance;
    }

    @Override
    public double calculatePerimeter(List<Point> points) {
        return Point.distanceBetweenPoints(points.get(0), points.get(1));
    }

    @Override
    public double calculateArea(List<Point> points) {
        return 0;
    }
}
