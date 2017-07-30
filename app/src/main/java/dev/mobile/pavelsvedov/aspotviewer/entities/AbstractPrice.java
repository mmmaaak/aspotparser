package dev.mobile.pavelsvedov.aspotviewer.entities;

import dev.mobile.pavelsvedov.aspotviewer.enums.PriceType;

public class AbstractPrice {
    protected PriceType type;

    public PriceType getType() {
        return type;
    }

    public void setType(PriceType type) {
        this.type = type;
    }
}
