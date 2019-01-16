package com.agarwal.retrofitdemo.Model;

import com.google.gson.annotations.SerializedName;

public class HomeCities {
    @SerializedName("tagline")
    private String title;
    @SerializedName("description")
    private String shortdesc;
    @SerializedName("name")
    private String name;
    @SerializedName("photo")
    private String image;

    public HomeCities(String title, String shortdesc, String image, String name) {
        this.title = title;
        this.shortdesc = shortdesc;
        this.image = image;
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
