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
        List<Point> pointsForMultiAngel = new ArrayList<>();
        pointsForMultiAngel.add(new Point(1, 1));
        pointsForMultiAngel.add(new Point(4, 1));
        pointsForMultiAngel.add(new Point(4, 4));
        pointsForMultiAngel.add(new Point(1, 4));

        List<Point> pointsForTriangle = new ArrayList<>();
        pointsForTriangle.add(new Point(1, 1));
        pointsForTriangle.add(new Point(1, 5));
        pointsForTriangle.add(new Point(4, 1));

        try {
            Figure multiAngeleFigure = new FigureFactory().createFigure(FigureType.MULTIANGLE, pointsForMultiAngel);
            multiAngeleFigure.outputInformation();
            logger.log(Level.INFO, multiAngeleFigure.calculateArea());
            logger.log(Level.INFO, multiAngeleFigure.calculatePerimeter());
        } catch (FigureException e) {
            logger.log(Level.ERROR, "Exception " + e.toString());
        }

        try {
            Figure triangle = new FigureFactory().createFigure(FigureType.TRIANGLE, pointsForTriangle);
            triangle.outputInformation();
            logger.log(Level.INFO, triangle.calculateArea());
            logger.log(Level.INFO, triangle.calculatePerimeter());
        } catch (FigureException e) {
            logger.log(Level.ERROR, "Exception " + e.toString());

        }
    }
}
