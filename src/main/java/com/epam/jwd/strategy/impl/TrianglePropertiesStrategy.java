package com.epam.jwd.strategy.impl;

import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.FigurePropertiesStrategy;

import java.util.List;

import static com.epam.jwd.model.Point.distanceBetweenPoints;

public class TrianglePropertiesStrategy implements FigurePropertiesStrategy {
    //lazy singleton
    private static TrianglePropertiesStrategy instance;

    public static TrianglePropertiesStrategy getInstance(){
        if (instance == null){
            instance = new TrianglePropertiesStrategy();
        }
        return instance;
    }

    @Override
    public double calculatePerimeter(List<Point> points) {
        return distanceBetweenPoints(points.get(0), points.get(1))
                + distanceBetweenPoints(points.get(1), points.get(2))
                + distanceBetweenPoints(points.get(2), points.get(0));
    }

    @Override
    public double calculateArea(List<Point> points) {
        double area = 0;
        //Gauss area formula
        for (int i = 0; i < 3; i++){
            if (i == 2) {
                area += points.get(i).getX() * points.get(0).getY()
                        - points.get(i).getY() * points.get(0).getX();
            } else {
                area += points.get(i).getX() * points.get(i + 1).getY()
                        - points.get(i).getY() * points.get(i + 1).getX();
            }
        }
        return 0.5 * Math.abs(area);
    }

    @Override
    public boolean exist(List<Point> points) {
        boolean triangle = true;
        if (distanceBetweenPoints(points.get(0), points.get(1)) + distanceBetweenPoints(points.get(1), points.get(2))
                <= distanceBetweenPoints(points.get(0), points.get(2))
                || distanceBetweenPoints(points.get(0), points.get(1))
                + distanceBetweenPoints(points.get(0), points.get(2))
                <= distanceBetweenPoints(points.get(1), points.get(2))
                || distanceBetweenPoints(points.get(1), points.get(2))
                + distanceBetweenPoints(points.get(0), points.get(2))
                <= distanceBetweenPoints(points.get(0), points.get(1))) {
            triangle = false;
        }
        return triangle;
    }
}
