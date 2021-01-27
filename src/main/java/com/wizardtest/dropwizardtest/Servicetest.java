package com.wizardtest.dropwizardtest;

import com.wizardtest.dropwizardtest.resouces.FirstResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

public class Servicetest extends Application<ConfigurationTest> {

    public static void main(String[] args) throws Exception {
        new Servicetest().run(args);
    }

    @Override
    public void initialize(Bootstrap<ConfigurationTest> bootstrap) {
    }



    @Override
    public void run(ConfigurationTest configurationTest, Environment environment) throws Exception {
        //DBConnection.connect();
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        environment.jersey().register(new FirstResource());
    }
}
