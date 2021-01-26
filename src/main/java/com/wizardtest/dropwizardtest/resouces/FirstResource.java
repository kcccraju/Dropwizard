package com.wizardtest.dropwizardtest.resouces;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/getGeolocation/{ipaddress}")
public class FirstResource {

    @GET
    public String getgeolocations(@PathParam("ipaddress") String ipaddress){
        return "234235,232352";
    }
}
