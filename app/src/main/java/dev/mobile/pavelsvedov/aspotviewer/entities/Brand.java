package dev.mobile.pavelsvedov.aspotviewer.entities;

import com.google.gson.annotations.SerializedName;


public class Brand {
    String name;
    String alias;

    @SerializedName("image_url")
    String imageURL;

    @SerializedName("models_url")
    String modelsURL;

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getModelsURL() {
        return modelsURL;
    }
}
