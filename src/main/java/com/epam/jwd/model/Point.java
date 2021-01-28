package com.epam.jwd.model;

import org.apache.log4j.Level;

import static com.epam.jwd.app.Main.logger;

public class Point{
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void getPoint(){
        logger.log(Level.INFO, "Point info: x = " + x + ", y = " + y);
    }
}
