package com.wizardtest.dropwizardtest.moldel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Geoloaction {
    private int id;
    private Timestamp timeDate;
    private String ipAddress;
    private String location;
}
