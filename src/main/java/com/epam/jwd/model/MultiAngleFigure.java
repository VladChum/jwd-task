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

    public boolean existMultiAngelFigure() {
        boolean multiAngelFigure = true;
        //check not the location of points in a line
        for (int i = 0; i < points.size(); i++) {
            int numberEqualX = 0;
            int numberEqualY = 0;
            for (int j = 0; j < points.size(); j++) {
                if (points.get(j).getX() == points.get(i).getX()) {
                    numberEqualX++;
                }
                if (points.get(j).getY() == points.get(i).getY()) {
                    numberEqualY++;
                }
            }
            if (numberEqualX == points.size() || numberEqualY == points.size()) {
                multiAngelFigure = false;
                break;
            }
        }
        return multiAngelFigure;
    }
}
