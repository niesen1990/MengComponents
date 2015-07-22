package com.cmbb.smartkids.menglisttest.network;

import java.util.HashMap;
import java.util.Map;

public class HomeSameAge {

    private String bigImg;
    private Object bigImgHeight;
    private Object bigImgWidth;
    private String connector;
    private String context;
    private Object count;
    private Object id;
    private String smallImg;
    private Object smallImgHeight;
    private Object smallImgWidth;
    private String title;
    private String type;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The bigImg
     */
    public String getBigImg() {
        return bigImg;
    }

    /**
     * @param bigImg The bigImg
     */
    public void setBigImg(String bigImg) {
        this.bigImg = bigImg;
    }

    /**
     * @return The bigImgHeight
     */
    public Object getBigImgHeight() {
        return bigImgHeight;
    }

    /**
     * @param bigImgHeight The bigImgHeight
     */
    public void setBigImgHeight(Object bigImgHeight) {
        this.bigImgHeight = bigImgHeight;
    }

    /**
     * @return The bigImgWidth
     */
    public Object getBigImgWidth() {
        return bigImgWidth;
    }

    /**
     * @param bigImgWidth The bigImgWidth
     */
    public void setBigImgWidth(Object bigImgWidth) {
        this.bigImgWidth = bigImgWidth;
    }

    /**
     * @return The connector
     */
    public String getConnector() {
        return connector;
    }

    /**
     * @param connector The connector
     */
    public void setConnector(String connector) {
        this.connector = connector;
    }

    /**
     * @return The context
     */
    public String getContext() {
        return context;
    }

    /**
     * @param context The context
     */
    public void setContext(String context) {
        this.context = context;
    }

    /**
     * @return The count
     */
    public Object getCount() {
        return count;
    }

    /**
     * @param count The count
     */
    public void setCount(Object count) {
        this.count = count;
    }

    /**
     * @return The id
     */
    public Object getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Object id) {
        this.id = id;
    }

    /**
     * @return The smallImg
     */
    public String getSmallImg() {
        return smallImg;
    }

    /**
     * @param smallImg The smallImg
     */
    public void setSmallImg(String smallImg) {
        this.smallImg = smallImg;
    }

    /**
     * @return The smallImgHeight
     */
    public Object getSmallImgHeight() {
        return smallImgHeight;
    }

    /**
     * @param smallImgHeight The smallImgHeight
     */
    public void setSmallImgHeight(Object smallImgHeight) {
        this.smallImgHeight = smallImgHeight;
    }

    /**
     * @return The smallImgWidth
     */
    public Object getSmallImgWidth() {
        return smallImgWidth;
    }

    /**
     * @param smallImgWidth The smallImgWidth
     */
    public void setSmallImgWidth(Object smallImgWidth) {
        this.smallImgWidth = smallImgWidth;
    }

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "HomeSameAge{" +
                "bigImg='" + bigImg + '\'' +
                ", bigImgHeight=" + bigImgHeight +
                ", bigImgWidth=" + bigImgWidth +
                ", connector='" + connector + '\'' +
                ", context='" + context + '\'' +
                ", count=" + count +
                ", id=" + id +
                ", smallImg='" + smallImg + '\'' +
                ", smallImgHeight=" + smallImgHeight +
                ", smallImgWidth=" + smallImgWidth +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}