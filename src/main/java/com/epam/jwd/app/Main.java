package com.epam.jwd.app;

import com.epam.jwd.model.*;
import org.apache.log4j.Logger;


public class Main {
    public static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        final int pointsQuantity = 4;
        final int linesQuantity = 2;
        final int trianglesQuantity = 2;
        final int squaresQuantity = 1;

        Point[] points = new Point[pointsQuantity];
        Line[] lines = new Line[linesQuantity];
        Triangle[] triangles = new Triangle[trianglesQuantity];
        Square[] squares = new Square[squaresQuantity];

        points[0] = new Point(1,1);
        points[1] = new Point(1,2);
        points[2] = new Point(2,2);
        points[3] = new Point(2,1);

        int numberPoint = 0;
        do {
            points[numberPoint].getPoint();
            numberPoint++;
        } while (numberPoint < points.length);

        lines[0] = new Line(points[0], points[2]);
        lines[1] = new Line(points[1], new Point(1, 2));
        triangles[0] = new Triangle(points[0], points[1], points[2]);
        triangles[1] = new Triangle(points[0], points[1], new Point(1, -1));
        squares[0] = new Square(points[0], points[1], points[2], points[3]);

        printFigureInfo(lines);
        printFigureInfo(triangles);
        printFigureInfo(squares);
    }

    static void printFigureInfo(Figure [] figures){
        for (Figure figure : figures){
            figure.getInfo();
        }
    }
}
