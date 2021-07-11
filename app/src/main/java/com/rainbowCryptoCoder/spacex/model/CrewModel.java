package com.rainbowCryptoCoder.spacex.model;

import com.google.gson.annotations.SerializedName;

public class CrewModel {
    @SerializedName("name")
    String name;

    @SerializedName("agency")
    String agency;

    @SerializedName("image")
    String image;

    @SerializedName("wikipedia")
    String wikipedia;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }
}
