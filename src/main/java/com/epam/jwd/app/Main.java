package com.epam.jwd.app;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws FigureException {
        List<Point> pointsForLine = new ArrayList<>();
        pointsForLine.add(new Point(1, 1));
        pointsForLine.add(new Point(2, 2));
        pointsForLine.add(new Point(1, 1));
        pointsForLine.add(new Point(2, 2));

        List<Point> pointsForTriangle = new ArrayList<>();
        pointsForTriangle.add(new Point(1, 1));
        pointsForTriangle.add(new Point(1, 5));
        pointsForTriangle.add(new Point(4, 1));

        Figure triangle = new FigureFactory().createFigure(FigureType.TRIANGLE, pointsForTriangle);
        triangle.outputInformation();
        logger.log(Level.INFO, triangle.calculateArea());
        logger.log(Level.INFO, triangle.calculatePerimeter());
    }
}
