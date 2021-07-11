package com.rainbowCryptoCoder.spacex.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "RecentItem")

public class RecentItem {
    //this class for local database !! and not using in firebase..

    //todo be sure from primary key here !!!

    @NonNull
    @PrimaryKey
    String uid;
    String name;
    String agency;
    String wikiLink;
    String imageUrl;//i will use this probarty to get last 10 object depend this..



    /*
     //we add this key .. because  if we are in ViewWallPAper activity and write
                // method there to increase number of views..
                // so we need referance to
                // get that child ..and if we are here in this class ..
                // and go to View activity .. we must set the key value to use it for referance child
                //so we must store the key in  RecentItem to be able to retrive key
     */
    String key;

    @Ignore
    public RecentItem() {
    }

    public RecentItem(@NonNull String uid, String name, String agency, String wikiLink, String imageUrl) {
        this.uid = uid;
        this.name = name;
        this.agency = agency;
        this.wikiLink = wikiLink;
        this.imageUrl = imageUrl;
    }

    @NonNull
    public String getUid() {
        return uid;
    }

    public void setUid(@NonNull String uid) {
        this.uid = uid;
    }

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

    public String getWikiLink() {
        return wikiLink;
    }

    public void setWikiLink(String wikiLink) {
        this.wikiLink = wikiLink;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "RecentItem{" +
                "name='" + name + '\'' +
                "agency='" + agency + '\'' +
                "wikiLink='" + wikiLink + '\'' +
                "imageUrl='" + imageUrl + '\'' +
                '}';
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
