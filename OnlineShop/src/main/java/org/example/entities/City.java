package org.example.entities;

public class City {
    private int cityId;
    private String cityName;
    private String EDT;

    public City(int cityId, String cityName, String EDT) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.EDT = EDT;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getEDT() {
        return EDT;
    }

    public void setEDT(String EDT) {
        this.EDT = EDT;
    }
}
