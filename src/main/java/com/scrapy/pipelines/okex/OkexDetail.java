package com.scrapy.pipelines.okex;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * Created by marico on 2018/2/23.
 */
@Gecco(matchUrl = "https://support.okex.com/hc/zh-cn/articles/{code}", pipelines = "okexDetailPipeline")
public class OkexDetail implements HtmlBean {
    @HtmlField(cssPath = ".article-title")
    private String title;

    @HtmlField(cssPath = ".article-body")
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
