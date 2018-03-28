package com.scrapy;

import com.geccocrawler.gecco.GeccoEngine;

import java.io.IOException;

public class BitcvApplicationTests {

    private static void scrapy(String packageStr, String startUrl) {
        GeccoEngine.create()
                //工程的包路径
                .classpath(packageStr)
                //开始抓取的页面地址HrefBean
                .start(startUrl)
                //开启几个爬虫线程
                .thread(10)
                //单个爬虫每次抓取完一个请求后的间隔时间
                .interval(5)
                //使用pc端userAgent
                .mobile(false)
                //开始运行
                .run();
    }

    public static void binanceScrapy() {
        scrapy("com.scrapy.pipelines.binance", "https://support.binance.com/hc/zh-cn/sections/115000122291-%E5%B8%81%E7%A7%8D%E4%BB%8B%E7%BB%8D?page=1");
    }

    public static void otcbtcScrapy() {
        scrapy("com.scrapy.pipelines.otcbtc", "https://support.otcbtc.com/hc/zh-cn/sections/115000739411-%E5%B8%81%E7%A7%8D%E4%BB%8B%E7%BB%8D?page=1");
    }

    public static void okexScrapy() {
        scrapy("com.scrapy.pipelines.okex", "https://support.okex.com/hc/zh-cn/sections/115000437971-Cryptocurrency-Intro?page=1");
    }


    public static void main(String[] args) throws IOException {
        binanceScrapy();
        otcbtcScrapy();
        okexScrapy();
    }
}
