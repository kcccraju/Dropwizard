package com.wizardtest.dropwizardtest.repository;

import com.wizardtest.dropwizardtest.moldel.Geoloaction;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

@Repository
public class GeolocationRepository {

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    Connection connection = null;
    Handle handle = null;
    GeolocationSQL geolocationSQL = null;

    @PostConstruct
    public void init() {
        connection = DataSourceUtils.getConnection(dataSource);
        handle = DBI.open(connection);
        geolocationSQL = handle.attach(GeolocationSQL.class);
    }

    public List<Geoloaction> findAllGeolocations() {
        return geolocationSQL.getGeoloactions();
    }

    public Integer addGeolocation(Geoloaction geoloaction) {
        return geolocationSQL.addGeolocation(geoloaction);
    }

    public List<Geoloaction> getGeoloactionByIpAddress(String ipAddress) {
        return geolocationSQL.getGeoloactionByIpAddress(ipAddress);
    }
}
