package com.scrapy.pipelines.binance;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * Created by marico on 2018/2/22.
 */
@Gecco(matchUrl = "https://support.binance.com/hc/zh-cn/articles/{code}", pipelines = "binaneDetailPipeline")
public class BinanceDetail implements HtmlBean {

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
