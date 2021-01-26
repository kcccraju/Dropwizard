package com.wizardtest.dropwizardtest;


import com.wizardtest.dropwizardtest.moldel.Geoloaction;
import com.wizardtest.dropwizardtest.repository.DBConnection;
import com.wizardtest.dropwizardtest.repository.GeolocationRepository;
import com.wizardtest.dropwizardtest.resouces.FirstResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class Servicetest extends Service<ConfigurationTest> {

    @Autowired
    private GeolocationRepository repository;

    @PostMapping("/addOrder")
    public String addOrder(@RequestBody Geoloaction geoloaction) {
        Integer count = repository.addGeolocation(geoloaction);
        return count + " record saved...";
    }

    @GetMapping("/getGeolocations")
    public List<Geoloaction> getOrders() {
        return repository.findAllGeolocations();
    }

    @GetMapping("/getGeolocations/{ipAddress}")
    public List<Geoloaction> getOrdersByPrice(@PathVariable String ipAddress) {
        return repository.getGeoloactionByIpAddress(ipAddress);
    }

    public static void main(String[] args) throws Exception {
        new Servicetest().run(args);
    }

    @Override
    public void initialize(Bootstrap<ConfigurationTest> bootstrap) {
    }

    @Override
    public void run(ConfigurationTest configurationTest, Environment environment) throws Exception {
        DBConnection.connect();
        environment.addResource(new FirstResource());
    }
}
