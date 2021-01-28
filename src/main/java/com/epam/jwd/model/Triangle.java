package com.epam.jwd.model;

import org.apache.log4j.Level;

import static com.epam.jwd.app.Main.logger;

public class Triangle extends Figure {
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;

    public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        super(FigureType.TRIANGLE);
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
    }

    @Override
    public void getInfo() {
        if (firstPoint.equals(secondPoint) ||
                firstPoint.equals(thirdPoint) ||
                secondPoint.equals(thirdPoint)) {
            logger.log(Level.ERROR, "Object id = " + getId() + " not " +
                    getFigureType());
        } else if (checkTriangle() == false) {
            logger.log(Level.ERROR, "Object id = " + getId() + " " +
                    getFigureType() + " cannot exist!");
        } else {
            logger.log(Level.INFO, "Triangle info: points (" +
                    firstPoint.getX() + "," + firstPoint.getY() + ") (" +
                    secondPoint.getX() + "," + secondPoint.getY() + ") (" +
                    thirdPoint.getX() + "," + thirdPoint.getY() + ") id: " +
                    getId());
        }
    }

    protected boolean checkTriangle() {
        boolean triangle = true;
        if (side(firstPoint, secondPoint) + side(secondPoint, thirdPoint) <=
                side(firstPoint, thirdPoint) || side(firstPoint, secondPoint) +
                side(firstPoint, thirdPoint) <= side(secondPoint, thirdPoint) ||
                side(secondPoint, thirdPoint) + side(firstPoint, thirdPoint) <=
                        side(firstPoint, secondPoint)) {
            triangle = false;
        }
        return triangle;
    }
}
