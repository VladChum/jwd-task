package com.epam.jwd.model;

import org.apache.log4j.Level;

import static com.epam.jwd.app.Main.logger;

public class Line extends Figure {
    private Point firstPoint;
    private Point secondPoint;

    public Point getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }

    public Line(Point firstPoint, Point secondPoint) {
        super(FigureType.LINE);
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    @Override
    public void getInfo() {
        if (firstPoint.equals(secondPoint)) {
            logger.log(Level.ERROR, "Object id = " + getId() + " not " +
                    getFigureType());
        } else {
            logger.log(Level.INFO, "Line info: points (" + firstPoint.getX() +
                    "," + firstPoint.getY() + ") (" + secondPoint.getX() + "," +
                    secondPoint.getY() + ") id: " + getId());
        }
    }
}
