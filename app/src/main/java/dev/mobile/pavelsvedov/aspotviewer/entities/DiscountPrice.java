package dev.mobile.pavelsvedov.aspotviewer.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class DiscountPrice extends AbstractPrice {
    String name;
    String alias;

    PriceColor color;
    Map<String, String> settings;
    Map<String, String> price;

    @SerializedName("image_url")
    String imageURL;

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

    public PriceColor getColor() {
        return color;
    }

    public Map<String, String> getSettings() {
        return settings;
    }

    public Map<String, String> getPrice() {
        return price;
    }

    public String getImageURL() {
        return imageURL;
    }
}
