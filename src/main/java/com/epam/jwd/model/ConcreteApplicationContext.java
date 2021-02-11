package com.epam.jwd.model;

import com.epam.jwd.decorator.PostProcessorCashDecorator;
import com.epam.jwd.factory.ApplicationContext;
import com.epam.jwd.factory.Factory;
import com.epam.jwd.decorator.LogPostProcessorDecorator;
import com.epam.jwd.decorator.PostProcessorDecorator;
import com.epam.jwd.decorator.PreProcessorDecorator;
import org.apache.log4j.Level;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jwd.app.Main.logger;

public class ConcreteApplicationContext implements ApplicationContext {
    private static List<Figure> figureCash = new ArrayList<>();

    public void setFigureCash(Figure figure) {
        this.figureCash.add(figure);
    }

    @Override
    public void outputFigureCash() {
        logger.log(Level.INFO, "Coll figure in figureCash :" + figureCash.size());
    }

    @Override
    public Factory createFigureFactory() {
        return new LogPostProcessorDecorator(new PostProcessorCashDecorator(
                new PostProcessorDecorator(new PreProcessorDecorator(new FigureFactory()))));
    }
}
