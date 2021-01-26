package com.wizardtest.dropwizardtest.repository;

import com.wizardtest.dropwizardtest.moldel.Geoloaction;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(value= GeolocationMapper.class)
public interface GeolocationSQL {

    @SqlQuery("select * from tbl_geolocation")
    public List<Geoloaction> getGeoloactions();

    @SqlUpdate("insert into tbl_geolocation (timeDate, ipAddress, location) value (:timeDate, :ipAddress, :location)")
    @GetGeneratedKeys
    public Integer addGeolocation(@BindBean Geoloaction geoloaction);

    @SqlQuery("Select * from tbl_geolocation where ipAddress=:ipAddress")
    public List<Geoloaction> getGeoloactionByIpAddress(@Bind String ipAddress);
}
