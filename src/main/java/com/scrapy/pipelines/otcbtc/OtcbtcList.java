package com.scrapy.pipelines.otcbtc;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HrefBean;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * Created by marico on 2018/2/22.
 */
@Gecco(matchUrl = "https://support.otcbtc.com/hc/zh-cn/sections/{code}?page={pageIndex}", pipelines="otcbtcListPipeline")
public class OtcbtcList implements HtmlBean {
    @Request
    private HttpRequest request;
    @RequestParameter
    private int pageIndex;
    @HtmlField(cssPath = ".article-list > li > a")
    private List<HrefBean> newList;
    @HtmlField(cssPath = ".pagination-last")
    private HrefBean lastPage;
    @HtmlField(cssPath = ".pagination-next")
    private HrefBean nextPage;

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public List<HrefBean> getNewList() {
        return newList;
    }

    public void setNewList(List<HrefBean> newList) {
        this.newList = newList;
    }

    public HrefBean getLastPage() {
        return lastPage;
    }

    public void setLastPage(HrefBean lastPage) {
        this.lastPage = lastPage;
    }

    public HrefBean getNextPage() {
        return nextPage;
    }

    public void setNextPage(HrefBean nextPage) {
        this.nextPage = nextPage;
    }
}
