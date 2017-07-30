package dev.mobile.pavelsvedov.aspotviewer.entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Map;

public class NormalPrice extends AbstractPrice {
    String name;

    Map<String, String> info;

    @SerializedName("image_url")
    String imageURL;

    ArrayList<NormalPriceItem> prices;
}
