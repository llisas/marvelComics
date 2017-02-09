
package com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.api.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Result {

    @SerializedName("characters")
    private Characters mCharacters;
    @SerializedName("collectedIssues")
    private List<Object> mCollectedIssues;
    @SerializedName("collections")
    private List<Collection> mCollections;
    @SerializedName("creators")
    private Creators mCreators;
    @SerializedName("dates")
    private List<Date> mDates;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("diamondCode")
    private String mDiamondCode;
    @SerializedName("digitalId")
    private Long mDigitalId;
    @SerializedName("ean")
    private String mEan;
    @SerializedName("events")
    private Events mEvents;
    @SerializedName("format")
    private String mFormat;
    @SerializedName("id")
    private Long mId;
    @SerializedName("images")
    private List<Image> mImages;
    @SerializedName("isbn")
    private String mIsbn;
    @SerializedName("issn")
    private String mIssn;
    @SerializedName("issueNumber")
    private Long mIssueNumber;
    @SerializedName("modified")
    private String mModified;
    @SerializedName("pageCount")
    private Long mPageCount;
    @SerializedName("prices")
    private List<Price> mPrices;
    @SerializedName("resourceURI")
    private String mResourceURI;
    @SerializedName("series")
    private Series mSeries;
    @SerializedName("stories")
    private Stories mStories;
    @SerializedName("textObjects")
    private List<TextObject> mTextObjects;
    @SerializedName("thumbnail")
    private Thumbnail mThumbnail;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("upc")
    private String mUpc;
    @SerializedName("urls")
    private List<Url> mUrls;
    @SerializedName("variantDescription")
    private String mVariantDescription;
    @SerializedName("variants")
    private List<Variant> mVariants;

    public Characters getCharacters() {
        return mCharacters;
    }

    public void setCharacters(Characters characters) {
        mCharacters = characters;
    }

    public List<Object> getCollectedIssues() {
        return mCollectedIssues;
    }

    public void setCollectedIssues(List<Object> collectedIssues) {
        mCollectedIssues = collectedIssues;
    }

    public List<Collection> getCollections() {
        return mCollections;
    }

    public void setCollections(List<Collection> collections) {
        mCollections = collections;
    }

    public Creators getCreators() {
        return mCreators;
    }

    public void setCreators(Creators creators) {
        mCreators = creators;
    }

    public List<Date> getDates() {
        return mDates;
    }

    public void setDates(List<Date> dates) {
        mDates = dates;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDiamondCode() {
        return mDiamondCode;
    }

    public void setDiamondCode(String diamondCode) {
        mDiamondCode = diamondCode;
    }

    public Long getDigitalId() {
        return mDigitalId;
    }

    public void setDigitalId(Long digitalId) {
        mDigitalId = digitalId;
    }

    public String getEan() {
        return mEan;
    }

    public void setEan(String ean) {
        mEan = ean;
    }

    public Events getEvents() {
        return mEvents;
    }

    public void setEvents(Events events) {
        mEvents = events;
    }

    public String getFormat() {
        return mFormat;
    }

    public void setFormat(String format) {
        mFormat = format;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public List<Image> getImages() {
        return mImages;
    }

    public void setImages(List<Image> images) {
        mImages = images;
    }

    public String getIsbn() {
        return mIsbn;
    }

    public void setIsbn(String isbn) {
        mIsbn = isbn;
    }

    public String getIssn() {
        return mIssn;
    }

    public void setIssn(String issn) {
        mIssn = issn;
    }

    public Long getIssueNumber() {
        return mIssueNumber;
    }

    public void setIssueNumber(Long issueNumber) {
        mIssueNumber = issueNumber;
    }

    public String getModified() {
        return mModified;
    }

    public void setModified(String modified) {
        mModified = modified;
    }

    public Long getPageCount() {
        return mPageCount;
    }

    public void setPageCount(Long pageCount) {
        mPageCount = pageCount;
    }

    public List<Price> getPrices() {
        return mPrices;
    }

    public void setPrices(List<Price> prices) {
        mPrices = prices;
    }

    public String getResourceURI() {
        return mResourceURI;
    }

    public void setResourceURI(String resourceURI) {
        mResourceURI = resourceURI;
    }

    public Series getSeries() {
        return mSeries;
    }

    public void setSeries(Series series) {
        mSeries = series;
    }

    public Stories getStories() {
        return mStories;
    }

    public void setStories(Stories stories) {
        mStories = stories;
    }

    public List<TextObject> getTextObjects() {
        return mTextObjects;
    }

    public void setTextObjects(List<TextObject> textObjects) {
        mTextObjects = textObjects;
    }

    public Thumbnail getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        mThumbnail = thumbnail;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getUpc() {
        return mUpc;
    }

    public void setUpc(String upc) {
        mUpc = upc;
    }

    public List<Url> getUrls() {
        return mUrls;
    }

    public void setUrls(List<Url> urls) {
        mUrls = urls;
    }

    public String getVariantDescription() {
        return mVariantDescription;
    }

    public void setVariantDescription(String variantDescription) {
        mVariantDescription = variantDescription;
    }

    public List<Variant> getVariants() {
        return mVariants;
    }

    public void setVariants(List<Variant> variants) {
        mVariants = variants;
    }

}
