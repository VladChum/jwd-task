package com.epam.jwd.model;

import com.epam.jwd.strategy.impl.TrianglePropertiesStrategy;
import org.apache.log4j.Level;

import java.util.List;

import static com.epam.jwd.app.Main.logger;
import static com.epam.jwd.model.Point.distanceBetweenPoints;

public class Triangle extends Figure {
    private List<Point> points;

    Triangle(List<Point> points) {
        super(FigureType.TRIANGLE);
        this.points = points;
    }

    @Override
    public List<Point> getPoints() {
        return points;
    }

    @Override
    public void outputInformation() {
        if (points.get(0).equals(points.get(1)) ||
                points.get(0).equals(points.get(2)) ||
                points.get(1).equals(points.get(2))) {
            logger.log(Level.ERROR, "Object id = " + getId() + " not "
                    + getFigureType());
        } else if (existTriangle() == false) {
            logger.log(Level.ERROR, "Object id = " + getId() + " "
                    + getFigureType() + " cannot exist!");
        } else {
            logger.log(Level.INFO, "Triangle info: points ("
                    + points.get(0).getX() + "," + points.get(0).getY() + ") ("
                    + points.get(1).getX() + "," + points.get(1).getY() + ") ("
                    + points.get(2).getX() + "," + points.get(2).getY() + ") id: "
                    + getId());
        }
    }

    public boolean existTriangle() {
        boolean triangle = true;
        if (distanceBetweenPoints(points.get(0), points.get(1)) + distanceBetweenPoints(points.get(1), points.get(2))
                <= distanceBetweenPoints(points.get(0), points.get(2))
                || distanceBetweenPoints(points.get(0), points.get(1))
                + distanceBetweenPoints(points.get(0), points.get(2))
                <= distanceBetweenPoints(points.get(1), points.get(2))
                || distanceBetweenPoints(points.get(1), points.get(2))
                + distanceBetweenPoints(points.get(0), points.get(2))
                <= distanceBetweenPoints(points.get(0), points.get(1))) {
            triangle = false;
        }
        return triangle;
    }
}
