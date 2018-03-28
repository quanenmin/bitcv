package com.scrapy.pipelines.otcbtc;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.scrapy.entity.ScrapyObj;
import com.scrapy.utils.FileUtil;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

/**
 * Created by marico on 2018/2/23.
 */
@PipelineName("otcbtcDetailPipeline")
public class OtcbtcDetailPipeline implements Pipeline<OtcbtcDetail> {
    @Override
    public void process(OtcbtcDetail otcbtcDetail) {
        //名称
        String name = otcbtcDetail.getTitle();
        int begin = name.lastIndexOf("是");
        int end = name.lastIndexOf("？");
        if (begin > 0 && end > 0) {
            name = name.substring(begin + 1, end - 1);
        }

        String body = Jsoup.clean(otcbtcDetail.getBody(), Whitelist.basic());
        Document document = Jsoup.parse(body, "UTF-8");
        Element element = document.body();

//        System.out.println(element.html());

        //简介
        String abstractInfo = "";
        //官方网站
        String homeUrl = "";
        //白皮书
        String pagerUrl = "";

        Elements children = element.children();
        for (Element child : children) {
            if (child.text().contains("特别声明") || StringUtils.isBlank(child.text().replace(" ", ""))) {
                continue;
            }

            if (child.text().contains("相关链接") || StringUtils.isBlank(child.text().replace(" ", ""))) {
                continue;
            }

            if (child.text().contains("官方网址") || child.text().contains("官方网站") || child.text().contains("官网")) {
                Elements elements = child.select("a");
                if (elements != null && elements.first() != null) {
                    homeUrl = elements.first().attr("href");
                    continue;
                }
            }

            if (child.text().contains("白皮书")) {
                Elements elements = child.select("a");
                if (elements != null && elements.first() != null) {
                    pagerUrl = elements.first().attr("href");
                    continue;
                }
            }

            abstractInfo += child.text();
        }

        ScrapyObj obj = new ScrapyObj();
        obj.setName(name);
        obj.setPagerUrl(pagerUrl);
        obj.setHomeUrl(homeUrl);
        obj.setAbstractInfo(abstractInfo);
        System.out.println(obj.toString());

        FileUtil.write(obj.toString(), "/Users/marico/Desktop/binance.txt");
    }
}
