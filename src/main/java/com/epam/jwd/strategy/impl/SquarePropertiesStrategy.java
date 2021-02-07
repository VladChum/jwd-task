package com.epam.jwd.strategy.impl;

import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.FigurePropertiesStrategy;

import java.util.List;

import static com.epam.jwd.model.Point.distanceBetweenPoints;

public enum SquarePropertiesStrategy implements FigurePropertiesStrategy {
    INSTANCE;

    @Override
    public double calculatePerimeter(List<Point> points) {
        return distanceBetweenPoints(points.get(0), points.get(1))
                + distanceBetweenPoints(points.get(1), points.get(2))
                + distanceBetweenPoints(points.get(2), points.get(3))
                + distanceBetweenPoints(points.get(3), points.get(0));
    }

    @Override
    public double calculateArea(List<Point> points) {
        double area = 0;
        //Gauss area formula
        for (int i = 0; i < 4; i++){
            if (i == 3) {
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
        boolean result = false;
        if ((distanceBetweenPoints(points.get(0), points.get(1)) == distanceBetweenPoints(points.get(1), points.get(2))
                && distanceBetweenPoints(points.get(2), points.get(3))
                == distanceBetweenPoints(points.get(3), points.get(0)))
                && distanceBetweenPoints(points.get(0), points.get(2))
                == distanceBetweenPoints(points.get(1), points.get(3))) {
            result = true;
        }
        return result;
    }
}
