package com.epam.jwd.strategy.impl;

import com.epam.jwd.model.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrianglePropertiesStrategyTest {

    TrianglePropertiesStrategy trianglePropertiesStrategy;

    @BeforeEach
    void initializeTrianglePropertiesStrategy() {
        trianglePropertiesStrategy = new TrianglePropertiesStrategy();
    }

    @Test
    void calculatePerimeter() {
        List<Point> pointsForTriangle = new ArrayList<>();
        pointsForTriangle.add(new Point(1, 1));
        pointsForTriangle.add(new Point(1, 5));
        pointsForTriangle.add(new Point(4, 1));

        double actual = trianglePropertiesStrategy.calculatePerimeter(pointsForTriangle);
        double expect = 12;

        assertEquals(expect, actual);
    }

    @Test
    void calculateArea() {
        List<Point> pointsForTriangle = new ArrayList<>();
        pointsForTriangle.add(new Point(1, 1));
        pointsForTriangle.add(new Point(1, 5));
        pointsForTriangle.add(new Point(4, 1));

        double actual = trianglePropertiesStrategy.calculateArea(pointsForTriangle);
        double expect = 6;

        assertEquals(expect, actual);
    }

    @Test
    void exist_true() {
        List<Point> pointsForTriangle = new ArrayList<>();
        pointsForTriangle.add(new Point(1, 1));
        pointsForTriangle.add(new Point(1, 5));
        pointsForTriangle.add(new Point(4, 1));

        boolean actual = trianglePropertiesStrategy.exist(pointsForTriangle);
        boolean expect = true;

        assertEquals(expect, actual);
    }

    @Test
    void exist_false() {
        List<Point> pointsForTriangle = new ArrayList<>();
        pointsForTriangle.add(new Point(1, 1));
        pointsForTriangle.add(new Point(1, 5));
        pointsForTriangle.add(new Point(1, 1));

        boolean actual = trianglePropertiesStrategy.exist(pointsForTriangle);
        boolean expect = false;

        assertEquals(expect, actual);
    }
}