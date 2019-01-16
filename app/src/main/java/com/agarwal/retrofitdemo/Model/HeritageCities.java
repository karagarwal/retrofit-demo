package com.agarwal.retrofitdemo.Model;

import com.google.gson.annotations.SerializedName;

public class HeritageCities {
    @SerializedName("cityName")
    private String city;
    @SerializedName("description")
    private String shortdesc;
    @SerializedName("placeName")
    private String name;
    @SerializedName("image1")
    private String image;
    @SerializedName("status_code")
    private String status_code;

    public HeritageCities(String city, String shortdesc, String image, String name, String status_code) {
        this.city = city;
        this.shortdesc = shortdesc;
        this.image = image;
        this.name = name;
        this.status_code = status_code;
    }

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
