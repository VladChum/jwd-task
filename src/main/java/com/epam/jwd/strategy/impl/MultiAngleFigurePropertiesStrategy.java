package com.epam.jwd.strategy.impl;

import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.FigurePropertiesStrategy;

import java.util.List;

import static com.epam.jwd.model.Point.distanceBetweenPoints;

public class MultiAngleFigurePropertiesStrategy implements FigurePropertiesStrategy {

    //lazy singleton
    private static MultiAngleFigurePropertiesStrategy instance;

    public static synchronized MultiAngleFigurePropertiesStrategy getInstance(){
        if (instance == null){
            instance = new MultiAngleFigurePropertiesStrategy();
        }
        return instance;
    }

    @Override
    public double calculatePerimeter(List<Point> points) {
        double perimeter = 0;
        for (int i = 0; i < points.size(); i++) {
            if (i == points.size() - 1) {
                perimeter += distanceBetweenPoints(points.get(i), points.get(0));
            } else {
                perimeter += distanceBetweenPoints(points.get(i), points.get(i + 1));
            }
        }

        return perimeter;
    }

    @Override
    public double calculateArea(List<Point> points) {
        double area = 0;
        //Gauss area formula
        for (int i = 0; i < points.size(); i++) {
            if (i == points.size() - 1) {
                area += points.get(i).getX() * points.get(0).getY()
                        - points.get(i).getY() * points.get(0).getX();
            } else {
                area += points.get(i).getX() * points.get(i + 1).getY()
                        - points.get(i).getY() * points.get(i + 1).getX();
            }
        }
        return 0.5 * Math.abs(area);
    }
}
