package com.epam.jwd.strategy.impl;

import com.epam.jwd.model.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MultiAngleFigurePropertiesStrategyTest {
    MultiAngleFigurePropertiesStrategy multiAngleFigurePropertiesStrategy;

    @BeforeEach
    void initializeMultiAngeleFigurePropertiesStrategy() {
        multiAngleFigurePropertiesStrategy = new MultiAngleFigurePropertiesStrategy();
    }
    @Test
    void calculatePerimeter() {
        List<Point> pointsForMultiAngel = new ArrayList<>();
        pointsForMultiAngel.add(new Point(1, 1));
        pointsForMultiAngel.add(new Point(4, 1));
        pointsForMultiAngel.add(new Point(4, 4));
        pointsForMultiAngel.add(new Point(1, 4));

        double actual = multiAngleFigurePropertiesStrategy.calculatePerimeter(pointsForMultiAngel);
        double expect = 12;
        assertEquals(expect, actual);
    }

    @Test
    void calculateArea() {
        List<Point> pointsForMultiAngel = new ArrayList<>();
        pointsForMultiAngel.add(new Point(1, 1));
        pointsForMultiAngel.add(new Point(4, 1));
        pointsForMultiAngel.add(new Point(4, 4));
        pointsForMultiAngel.add(new Point(1, 4));

        double actual = multiAngleFigurePropertiesStrategy.calculateArea(pointsForMultiAngel);
        double expect = 9;
        assertEquals(expect, actual);
    }

    @Test
    void exist_true() {
        List<Point> pointsForMultiAngel = new ArrayList<>();
        pointsForMultiAngel.add(new Point(1, 1));
        pointsForMultiAngel.add(new Point(4, 1));
        pointsForMultiAngel.add(new Point(4, 4));
        pointsForMultiAngel.add(new Point(1, 4));

        boolean actual = multiAngleFigurePropertiesStrategy.exist(pointsForMultiAngel);
        boolean expect = true;
        assertEquals(expect, actual);
    }

    @Test
    void exist_false() {
        List<Point> pointsForMultiAngel = new ArrayList<>();
        pointsForMultiAngel.add(new Point(1, 1));
        pointsForMultiAngel.add(new Point(4, 1));
        pointsForMultiAngel.add(new Point(1, 1));
        pointsForMultiAngel.add(new Point(1, 1));

        boolean actual = multiAngleFigurePropertiesStrategy.exist(pointsForMultiAngel);
        boolean expect = false;
        assertEquals(expect, actual);
    }
}