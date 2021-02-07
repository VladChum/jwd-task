package com.epam.jwd.model;

import com.epam.jwd.Factory.ApplicationContext;
import com.epam.jwd.Factory.Factory;
import com.epam.jwd.decorator.LogPostProcessorDecorator;
import com.epam.jwd.decorator.PostProcessorDecorator;
import com.epam.jwd.decorator.PreProcessorDecorator;

public class ConcreteApplicationContext implements ApplicationContext {
    @Override
    public Factory createFigureFactory() {
        return new LogPostProcessorDecorator(new PostProcessorDecorator(
                new PreProcessorDecorator(new FigureFactory())));
    }
}
