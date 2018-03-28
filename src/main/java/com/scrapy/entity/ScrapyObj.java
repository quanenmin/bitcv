package com.scrapy.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by marico on 2018/2/23.
 */
public class ScrapyObj {
    private String name;
    private String abstractInfo;
    private String homeUrl;
    private String pagerUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbstractInfo() {
        return abstractInfo;
    }

    public void setAbstractInfo(String abstractInfo) {
        this.abstractInfo = abstractInfo;
    }

    public String getHomeUrl() {
        return homeUrl;
    }

    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl;
    }

    public String getPagerUrl() {
        return pagerUrl;
    }

    public void setPagerUrl(String pagerUrl) {
        this.pagerUrl = pagerUrl;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
