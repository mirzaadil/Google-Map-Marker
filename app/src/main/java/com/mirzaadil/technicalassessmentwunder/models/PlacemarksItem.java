package com.mirzaadil.technicalassessmentwunder.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class PlacemarksItem implements Serializable {

    @SerializedName("address")
    private String address;

    @SerializedName("fuel")
    private int fuel;

    @SerializedName("exterior")
    private String exterior;

    @SerializedName("coordinates")
    private List<Double> coordinates;

    @SerializedName("name")
    private String name;

    @SerializedName("engineType")
    private String engineType;

    @SerializedName("vin")
    private String vin;

    @SerializedName("interior")
    private String interior;

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getFuel() {
        return fuel;
    }

    public void setExterior(String exterior) {
        this.exterior = exterior;
    }

    public String getExterior() {
        return exterior;
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }

    public List<Double> getCoordinates() {
        return coordinates;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getVin() {
        return vin;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public String getInterior() {
        return interior;
    }

    @Override
    public String toString() {
        return
                "PlacemarksItem{" +
                        "address = '" + address + '\'' +
                        ",fuel = '" + fuel + '\'' +
                        ",exterior = '" + exterior + '\'' +
                        ",coordinates = '" + coordinates + '\'' +
                        ",name = '" + name + '\'' +
                        ",engineType = '" + engineType + '\'' +
                        ",vin = '" + vin + '\'' +
                        ",interior = '" + interior + '\'' +
                        "}";
    }
}