package com.epam.jwd.model;

import com.epam.jwd.strategy.FigurePropertiesStrategy;
import com.epam.jwd.strategy.impl.LinePropertiesStrategy;
import com.epam.jwd.strategy.impl.MultiAngleFigurePropertiesStrategy;
import com.epam.jwd.strategy.impl.SquarePropertiesStrategy;
import com.epam.jwd.strategy.impl.TrianglePropertiesStrategy;

import java.util.List;

public abstract class Figure {
    private static int count = 0;
    private FigurePropertiesStrategy figurePropertiesStrategy;
    private FigureType figureType;
    private int id;

    public abstract List<Point> getPoints();

    public int getId() {
        return id;
    }

    public FigureType getFigureType() {
        return figureType;
    }

    public Figure(FigureType figureType) {
        this.figurePropertiesStrategy = LinePropertiesStrategy.getInstance();
        this.id = ++count;
        this.figureType = figureType;
    }

    public void setTriangleStrategy() {
        this.figurePropertiesStrategy = TrianglePropertiesStrategy.getInstance();
    }

    public void setLineStrategy() {
        this.figurePropertiesStrategy = LinePropertiesStrategy.getInstance();
    }

    public void setSquareStrategy() {
        this.figurePropertiesStrategy = SquarePropertiesStrategy.INSTANCE;
    }

    public void setMultiAngelFigureStrategy() {
        this.figurePropertiesStrategy = MultiAngleFigurePropertiesStrategy.getInstance();
    }

    public abstract void outputInformation();

    public double calculateArea() {
        return figurePropertiesStrategy.calculateArea(getPoints());
    }

    public double calculatePerimeter() {
        return figurePropertiesStrategy.calculatePerimeter(getPoints());
    }

    public boolean isExist() {
        return figurePropertiesStrategy.exist(getPoints());
    }

}
