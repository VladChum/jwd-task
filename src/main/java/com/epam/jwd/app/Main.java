package com.epam.jwd.app;

import com.epam.jwd.factory.ApplicationContext;
import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws FigureException {
        initializeFigure();
    }

    private static void initializeFigure() throws FigureException {
        List<Point> pointsForMultiAngel = new ArrayList<>();

        pointsForMultiAngel.add(new Point(1, 1));
        pointsForMultiAngel.add(new Point(4, 1));
        pointsForMultiAngel.add(new Point(4, 4));
        pointsForMultiAngel.add(new Point(1, 4));

        List<Point> pointsForTriangle = new ArrayList<>();
        pointsForTriangle.add(new Point(1, 1));
        pointsForTriangle.add(new Point(1, 5));
        pointsForTriangle.add(new Point(4, 1));

        List<Point> pointsForLine = new ArrayList<>();
        pointsForLine.add(new Point(1, 1));
        pointsForLine.add(new Point(1, 5));

        List<Point> pointsForSquare = new ArrayList<>();
        pointsForSquare.add(new Point(1, 1));
        pointsForSquare.add(new Point(6, 1));
        pointsForSquare.add(new Point(6, 6));
        pointsForSquare.add(new Point(1, 6));

        List<Point> pointsForTriangle2 = new ArrayList<>();
        pointsForTriangle.add(new Point(1, 1));
        pointsForTriangle.add(new Point(1, 5));
        pointsForTriangle.add(new Point(4, 1));

        ApplicationContext  applicationContext = new ConcreteApplicationContext();

        try {
            // multiAngel
            Figure multiAngel = applicationContext.createFigureFactory().createFigure(FigureType.MULTIANGLE,
                    pointsForMultiAngel);
            multiAngel.outputInformation();
            logger.log(Level.INFO, "MultiAngel: Area = " + multiAngel.calculateArea() + " Perimeter  = "
                    + multiAngel.calculatePerimeter());

            //triangle
            Figure triangle = applicationContext.createFigureFactory().createFigure(FigureType.TRIANGLE,
                    pointsForTriangle);
            triangle.outputInformation();
            logger.log(Level.INFO, "Triangle: Array = " + triangle.calculateArea()
                    + " Perimeter = " + triangle.calculatePerimeter());

            //Line
            Figure line = applicationContext.createFigureFactory().createFigure(FigureType.LINE, pointsForLine);
            line.outputInformation();
            logger.log(Level.INFO, "Line: Area = " + line.calculateArea()
                    + " Perimeter = " + line.calculatePerimeter());

            //Square
            Figure square = applicationContext.createFigureFactory().createFigure(FigureType.SQUARE,
                    pointsForSquare);
            square.outputInformation();
            logger.log(Level.INFO, "Square: Area = " + square.calculateArea()
                    + " Perimeter = " + square.calculatePerimeter());

            //MultiAngel
            Figure multiAngeleFigure = applicationContext.createFigureFactory().createFigure(FigureType.MULTIANGLE,
                    pointsForMultiAngel);
            multiAngeleFigure.outputInformation();
            logger.log(Level.INFO, "MultiAngel figure: Area = " + multiAngeleFigure.calculateArea()
                    + " Perimeter = " + multiAngeleFigure.calculatePerimeter());

            //triangle
            Figure triangle2 = applicationContext.createFigureFactory().createFigure(FigureType.TRIANGLE,
                    pointsForTriangle);
            triangle2.outputInformation();
            logger.log(Level.INFO, "Triangle: Array = " + triangle2.calculateArea()
                    + " Perimeter = " + triangle2.calculatePerimeter());
        } catch (FigureException e) {
            logger.log(Level.ERROR, "Exception " + e.toString());
        }

        applicationContext.outputFigureCash();
    }
}
