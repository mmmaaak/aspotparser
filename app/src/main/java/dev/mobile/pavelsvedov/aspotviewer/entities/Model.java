package dev.mobile.pavelsvedov.aspotviewer.entities;

import com.google.gson.annotations.SerializedName;


public class Model {
    String name;
    String alias;
    int offers;

    @SerializedName("image_url")
    String imageURL;

    @SerializedName("prices_url")
    String pricesURL;

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

    public int getOffers() {
        return offers;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getPricesURL() {
        return pricesURL;
    }
}
