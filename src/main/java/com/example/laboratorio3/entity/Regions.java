package com.example.laboratorio3.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "regions")
public class Regions {
    @Id
    private double regionId;
    private String regionName;

    public double getRegionId() {
        return regionId;
    }

    public void setRegionId(double regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
