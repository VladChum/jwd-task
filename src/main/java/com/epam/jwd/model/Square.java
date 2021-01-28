package com.epam.jwd.model;

import org.apache.log4j.Level;

import static com.epam.jwd.app.Main.logger;

public class Square extends Figure {
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    private Point fourthPoint;

    public Square(Point firstPoint, Point secondPoint, Point thirdPoint,
                  Point fourthPoint) {
        super(FigureType.SQUARE);
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
        this.fourthPoint = fourthPoint;
    }

    @Override
    public void getInfo() {
        if (comparePoints() == false) {
            logger.log(Level.ERROR, "Object id = " + getId() + " not " +
                    getFigureType());
        } else if (checkSquare() == false) {
            logger.log(Level.ERROR, "Object id = " + getId() + " " +
                    getFigureType() + " cannot exist!");
        } else {
            logger.log(Level.INFO, "Square info: points (" +
                    firstPoint.getX() + "," + firstPoint.getY() + ") (" +
                    secondPoint.getX() + "," + secondPoint.getY() + ") (" +
                    thirdPoint.getX() + "," + thirdPoint.getY() + ") (" +
                    fourthPoint.getX() + "," + fourthPoint.getY() + ") id: " +
                    getId());
        }
    }

    protected boolean checkSquare() {
        boolean result = false;
        if (side(firstPoint, secondPoint) == side(secondPoint, thirdPoint) &&
                side(thirdPoint, fourthPoint) == side(fourthPoint, firstPoint)
                && side(firstPoint, fourthPoint) ==
                side(firstPoint, secondPoint) &&
                side(firstPoint, thirdPoint) == side(secondPoint, fourthPoint)){
            result = true;
        }
        return result;
    }

    protected boolean comparePoints() {
        boolean result = true;
        if (firstPoint.equals(secondPoint) && firstPoint.equals(thirdPoint) &&
                firstPoint.equals(fourthPoint) && secondPoint.equals(thirdPoint)
                && secondPoint.equals(fourthPoint) &&
                thirdPoint.equals(fourthPoint)) {
            result = false;
        }
        logger.log(Level.DEBUG, "result = " + result);
        return result;
    }
}
