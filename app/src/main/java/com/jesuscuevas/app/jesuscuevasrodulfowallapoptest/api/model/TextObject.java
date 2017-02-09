
package com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.api.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class TextObject {

    @SerializedName("language")
    private String mLanguage;
    @SerializedName("text")
    private String mText;
    @SerializedName("type")
    private String mType;

    public String getLanguage() {
        return mLanguage;
    }

    public void setLanguage(String language) {
        mLanguage = language;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}
