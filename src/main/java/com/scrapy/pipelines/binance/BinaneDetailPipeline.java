package com.scrapy.pipelines.binance;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.scrapy.entity.ScrapyObj;
import com.scrapy.utils.FileUtil;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by marico on 2018/2/22.
 */
@PipelineName("binaneDetailPipeline")
public class BinaneDetailPipeline implements Pipeline<BinanceDetail> {

    @Override
    public void process(BinanceDetail binanceDetail) {
        //名称
        String name = binanceDetail.getTitle();
        int index = name.lastIndexOf("（");
        if (index > 0) {
            name = name.substring(index + 1, name.length() - 1);
        }

        Document document = Jsoup.parse(binanceDetail.getBody(), "UTF-8");
        Element element = document.body();

        //简介
        String abstractInfo = "";
        Elements children = element.children();
        for (Element child : children) {
            if (child.text().contains("相关链接")) {
                break;
            }

            abstractInfo += child.text();
        }

        //官方网站
        String homeUrl = "";
        //白皮书
        String pagerUrl = "";

        Element lastElement = children.last();
        while (StringUtils.isBlank(lastElement.text().replaceAll(" ", ""))) {
            lastElement = lastElement.previousElementSibling();
        }
        if (lastElement.text().contains("官方网站") || lastElement.text().contains("链接") || lastElement.text().contains("官网")) {
            Elements links = lastElement.getElementsByTag("a");
            //官网地址
            if (links != null) {
                if (links.size() > 0) {
                    homeUrl = links.get(0).attr("href");
                }

                if (links.size() > 1) {
                    pagerUrl = links.get(1).attr("href");
                }
            }
        }

        if (lastElement.text().contains("白皮书")) {
            Elements links = lastElement.getElementsByTag("a");
            if (links != null) {
                if (links.size() > 0) {
                    pagerUrl = links.get(0).attr("href");
                }
                if (links.size() > 1) {
                    pagerUrl = links.get(1).attr("href");
                }
            }
        }

        ScrapyObj obj = new ScrapyObj();
        obj.setName(name);
        obj.setAbstractInfo(abstractInfo);
        obj.setHomeUrl(homeUrl);
        obj.setPagerUrl(pagerUrl);
        System.out.println(obj.toString());

        FileUtil.write(obj.toString(), "/Users/marico/Desktop/binance.txt");
    }
}
