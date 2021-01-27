package com.wizardtest.dropwizardtest.resouces;

import com.wizardtest.dropwizardtest.moldel.Geoloaction;
import com.wizardtest.dropwizardtest.repository.GeolocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/service")
public class FirstResource {

    @Autowired
    GeolocationRepository geolocationRepository;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getGeolocations() { return "234235,232352"; }

    @Path("/findAllGeolocations")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Geoloaction> findAllGeolocations() {
        return geolocationRepository.findAllGeolocations();
    }

    @Path("/addGeolocation")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String addGeolocation(Geoloaction geoloaction) {
        Integer count = geolocationRepository.addGeolocation(geoloaction);
        return count + " record saved...";
    }

    @Path("/getGeoloactionByIpAddress/{ipAddress}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public List<Geoloaction> getGeoloactionByIpAddress(@PathVariable String ipAddress) {
        return geolocationRepository.getGeoloactionByIpAddress(ipAddress);
    }
}
