package com.epam.jwd.strategy.impl;

import com.epam.jwd.model.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SquarePropertiesStrategyTest {
    SquarePropertiesStrategy squarePropertiesStrategy;

    @BeforeEach
    void initializeSquarePropertiesStrategy() {
        squarePropertiesStrategy = SquarePropertiesStrategy.INSTANCE;
    }

    @Test
    void calculatePerimeter() {
        List<Point> pointsForSquare = new ArrayList<>();
        pointsForSquare.add(new Point(1, 1));
        pointsForSquare.add(new Point(6, 1));
        pointsForSquare.add(new Point(6, 6));
        pointsForSquare.add(new Point(1, 6));

        double actual = squarePropertiesStrategy.calculatePerimeter(pointsForSquare);
        double expect = 20;
        assertEquals(expect, actual);
    }

    @Test
    void calculateArea() {
        List<Point> pointsForSquare = new ArrayList<>();
        pointsForSquare.add(new Point(1, 1));
        pointsForSquare.add(new Point(6, 1));
        pointsForSquare.add(new Point(6, 6));
        pointsForSquare.add(new Point(1, 6));

        double actual = squarePropertiesStrategy.calculateArea(pointsForSquare);
        double expect = 25;
        assertEquals(expect, actual);
    }

    @Test
    void exist_true() {
        List<Point> pointsForSquare = new ArrayList<>();
        pointsForSquare.add(new Point(1, 1));
        pointsForSquare.add(new Point(6, 1));
        pointsForSquare.add(new Point(6, 6));
        pointsForSquare.add(new Point(1, 6));

        boolean actual = squarePropertiesStrategy.exist(pointsForSquare);
        boolean expect = true;
        assertEquals(expect, actual);
    }

    @Test
    void exist_false() {
        List<Point> pointsForSquare = new ArrayList<>();
        pointsForSquare.add(new Point(1, 1));
        pointsForSquare.add(new Point(6, 1));
        pointsForSquare.add(new Point(6, 6));
        pointsForSquare.add(new Point(5, 6));

        boolean actual = squarePropertiesStrategy.exist(pointsForSquare);
        boolean expect = false;
        assertEquals(expect, actual);
    }
}