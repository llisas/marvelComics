
package com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.api.model;

import com.google.gson.annotations.SerializedName;

public class Collection {

    @SerializedName("name")
    private String mName;
    @SerializedName("resourceURI")
    private String mResourceURI;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getResourceURI() {
        return mResourceURI;
    }

    public void setResourceURI(String resourceURI) {
        mResourceURI = resourceURI;
    }

}
