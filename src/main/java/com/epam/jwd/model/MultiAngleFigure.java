package com.epam.jwd.model;

import org.apache.log4j.Level;

import java.util.List;

import static com.epam.jwd.app.Main.logger;

public class MultiAngleFigure extends Figure {
    private List<Point> points;

    MultiAngleFigure(List<Point> points) {
        super(FigureType.MULTIANGLE);
        this.points = points;
    }

    @Override
    public List<Point> getPoints() {
        return points;
    }

    @Override
    public void outputInformation() {
        String information = "MultiAngel points: ";
        for (int i = 0; i < points.size(); i++) {
            information += "(" + points.get(i).getX() + "," + points.get(i).getY() + ") ";
        }
        information += "figure ID: " + getId();
        logger.log(Level.INFO, information);
    }
}
