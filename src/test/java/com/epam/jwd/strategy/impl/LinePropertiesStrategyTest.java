package com.epam.jwd.strategy.impl;

import com.epam.jwd.model.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinePropertiesStrategyTest {
    LinePropertiesStrategy linePropertiesStrategy;

    @BeforeEach
    void initializeLinePropertiesStrategy() {
        linePropertiesStrategy = LinePropertiesStrategy.getInstance();
    }

    @Test
    void calculatePerimeter() {
        List<Point> pointsForLine = new ArrayList<>();
        pointsForLine.add(new Point(1, 1));
        pointsForLine.add(new Point(1, 5));

        double actual = linePropertiesStrategy.calculatePerimeter(pointsForLine);
        double expect = 4;

        assertEquals(expect, actual);
    }

    @Test
    void exist_true() {
        List<Point> pointsForLine = new ArrayList<>();
        pointsForLine.add(new Point(1, 1));
        pointsForLine.add(new Point(1, 5));

        boolean actual = linePropertiesStrategy.exist(pointsForLine);
        boolean expect = true;

        assertEquals(expect, actual);
    }

    @Test
    void exist_false() {
        List<Point> pointsForLine = new ArrayList<>();
        pointsForLine.add(new Point(1, 1));
        pointsForLine.add(new Point(1, 1));

        boolean actual = linePropertiesStrategy.exist(pointsForLine);
        boolean expect = false;

        assertEquals(expect, actual);
    }
}