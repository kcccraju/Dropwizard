package com.wizardtest.dropwizardtest.repository;

import com.wizardtest.dropwizardtest.moldel.Geoloaction;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GeolocationMapper implements ResultSetMapper<Geoloaction> {
    @Override
    public Geoloaction map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Geoloaction(resultSet.getInt("id"),resultSet.getTimestamp("timeDate"),resultSet.getString("ipAddress"),resultSet.getString("location"));
    }
}
