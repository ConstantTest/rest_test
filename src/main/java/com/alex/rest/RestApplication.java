package com.alex.rest;

import com.alex.rest.config.AppConfiguration;
import com.alex.rest.resources.HelloWorldResource;
import com.alex.rest.resources.PriceResource;
import com.alex.rest.resources.ProductResource;
import com.alex.rest.service.PriceService;
import com.alex.rest.service.ProductService;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContextListener;

public class RestApplication extends Application<RestConfiguration> {

    public static void main(final String[] args) throws Exception {
        new RestApplication().run(args);
    }

    @Override
    public void initialize(final Bootstrap<RestConfiguration> bootstrap) {
    }

    @Override
    public void run(final RestConfiguration configuration,
                    final Environment environment) {

        AnnotationConfigWebApplicationContext context = createContext();
        environment.servlets().addServletListeners( new ContextLoaderListener(context));
        environment.jersey().packages("com.alex.rest.resources");
    }

    private AnnotationConfigWebApplicationContext createContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfiguration.class);
        context.refresh();
        return context;
    }
}
