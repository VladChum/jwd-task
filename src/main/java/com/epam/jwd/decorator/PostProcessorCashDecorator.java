package com.epam.jwd.decorator;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.Factory;
import com.epam.jwd.model.ConcreteApplicationContext;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;

import java.util.List;

public class PostProcessorCashDecorator extends ConcreteApplicationContext implements Factory {
    private final Factory factory;

    public PostProcessorCashDecorator(Factory factory) {
        this.factory = factory;
    }

    @Override
    public Figure createFigure(FigureType figureType, List<Point> points) throws FigureException {
        Figure figure = factory.createFigure(figureType, points);

        return equalsFigureAndFigureCash(figure);
    }

    private Figure equalsFigureAndFigureCash(Figure figure) {
        List<Figure> figureCash = getFigureCash();
        int equal = 0;
        for (int i = 0; i < figureCash.size(); i++) {
            if (figure.getFigureType().equals(figureCash.get(i).getFigureType())
                    && figure.getPoints().equals(figureCash.get(i).getPoints())) {
                figure = figureCash.get(i);
                equal++;
                break;
            }
        }
        if (equal == 0) {
            setFigureCash(figure);
        }
        return figure;
    }
}
