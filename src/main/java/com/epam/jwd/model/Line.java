package com.epam.jwd.model;

import org.apache.log4j.Level;
import java.util.List;

import static com.epam.jwd.app.Main.logger;

public class Line extends Figure {
    private List<Point> points;

    Line(List<Point> points) {
        super(FigureType.LINE);
        this.points = points;
    }

    @Override
    public List<Point> getPoints() {
        return points;
    }

    @Override
    public void outputInformation() {
        logger.log(Level.INFO, "Line info: points (" + points.get(0).getX() + "," + points.get(0).getY()
                + ") (" + points.get(1).getX() + "," + points.get(1).getY() + ") id: " + getId());
    }
}
