package com.epam.jwd.model;

import org.apache.log4j.Level;

import java.util.List;

import static com.epam.jwd.app.Main.logger;
import static com.epam.jwd.model.Point.distanceBetweenPoints;

public class Square extends Figure {
    private List<Point> points;

    Square(List<Point> points) {
        super(FigureType.SQUARE);
        this.points = points;
    }

    @Override
    public List<Point> getPoints() {
        return points;
    }

    @Override
    public void outputInformation() {
        if (comparePoints() == false) {
            logger.log(Level.ERROR, "Object id = " + getId() + " not " +
                    getFigureType());
        } else if (existSquare() == false) {
            logger.log(Level.ERROR, "Object id = " + getId() + " " +
                    getFigureType() + " cannot exist!");
        } else {
            logger.log(Level.INFO, "Square info: points ("
                    + points.get(0).getX() + "," + points.get(0).getY() + ") ("
                    + points.get(1).getX() + "," + points.get(1).getY() + ") ("
                    + points.get(2).getX() + "," + points.get(2).getY() + ") ("
                    + points.get(3).getX() + "," + points.get(3).getY() + ") id: "
                    + getId());
        }
    }

    public boolean existSquare() {
        boolean result = false;
        if (distanceBetweenPoints(points.get(0), points.get(1)) == distanceBetweenPoints(points.get(1), points.get(2))
                && distanceBetweenPoints(points.get(2), points.get(3))
                == distanceBetweenPoints(points.get(3), points.get(0))
                && distanceBetweenPoints(points.get(0), points.get(3))
                == distanceBetweenPoints(points.get(1), points.get(1))
                && distanceBetweenPoints(points.get(0), points.get(2))
                == distanceBetweenPoints(points.get(1), points.get(3))) {
            result = true;
        }
        return result;
    }

    protected boolean comparePoints() {
        boolean result = true;
        if (points.get(0).equals(points.get(1)) && points.get(0).equals(points.get(2))
                && points.get(0).equals(points.get(3)) && points.get(1).equals(points.get(2))
                && points.get(1).equals(points.get(3)) && points.get(2).equals(points.get(3))) {
            result = false;
        }
        logger.log(Level.DEBUG, "result = " + result);
        return result;
    }
}
