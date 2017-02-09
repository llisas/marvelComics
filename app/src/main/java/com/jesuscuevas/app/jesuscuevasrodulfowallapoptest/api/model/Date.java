
package com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.api.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Date {

    @SerializedName("date")
    private String mDate;
    @SerializedName("type")
    private String mType;

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}
