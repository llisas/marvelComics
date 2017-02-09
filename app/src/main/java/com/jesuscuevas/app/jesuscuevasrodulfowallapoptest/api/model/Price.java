
package com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.api.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Price {

    @SerializedName("price")
    private Double mPrice;
    @SerializedName("type")
    private String mType;

    public Double getPrice() {
        return mPrice;
    }

    public void setPrice(Double price) {
        mPrice = price;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}
