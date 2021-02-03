package com.epam.jwd.model;

import org.apache.log4j.Level;

import static com.epam.jwd.app.Main.logger;

public class Point{
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void outputInformation(){
        logger.log(Level.INFO, "Point info: x = " + x + ", y = " + y);
    }

    public static double distanceBetweenPoints(Point firstPoint, Point secondPoint) {
        return Math.sqrt(Math.pow(secondPoint.getX() - firstPoint.getX(), 2) +
                Math.pow(secondPoint.getY() - firstPoint.getY(), 2));
    }
}
