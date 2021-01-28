package com.epam.jwd.model;

import com.epam.jwd.app.Main;
import org.apache.log4j.Level;

import java.util.concurrent.atomic.AtomicInteger;

import static com.epam.jwd.app.Main.logger;

public class Figure {
    private static int count = 0;
    private int id;
    private FigureType figureType;

    public int getId() {
        return id;
    }

    public FigureType getFigureType() {
        return figureType;
    }

    public Figure(FigureType figureType){
        this.id = ++count;
        this.figureType = figureType;
    }

    static double side(Point firstPoint, Point secondPoint){
        double side;
        side = Math.sqrt(Math.pow(secondPoint.getX() - firstPoint.getX(), 2) +
                Math.pow(secondPoint.getY() - firstPoint.getY(), 2));
        return side;
    }

    public void getInfo() {
    }
}
