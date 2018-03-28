package com.scrapy.pipelines.okex;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.scrapy.entity.ScrapyObj;
import com.scrapy.pipelines.otcbtc.OtcbtcDetail;
import com.scrapy.utils.CharacterUtil;
import com.scrapy.utils.FileUtil;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

import java.util.List;

/**
 * Created by marico on 2018/2/23.
 */
@PipelineName("okexDetailPipeline")
public class OkexDetailPipeline implements Pipeline<OkexDetail> {
    @Override
    public void process(OkexDetail okexDetail) {
        //名称
        String name = okexDetail.getTitle().replaceAll("\\?", "").replaceAll("？", "").replaceAll("（", "(").replaceAll("）", ")");
        if (name.equals("OKEx上币申请")) {
            return;
        }

        String name1 = name;
        String name2;
        int begin = name.lastIndexOf("(");
        int end = name.lastIndexOf(")");
        if (begin > 0 && end > 0) {
            name1 = name.substring(begin + 1, end).trim();
            name2 = name.substring(0, begin);
        } else {
            name2 = name;
        }


        begin = name2.lastIndexOf("是");
        if (begin > 0) {
            name2 = name2.substring(begin + 1, name2.length()).trim();
        }

        if (CharacterUtil.isUpper(name1)) {
            name = name1;
        } else {
            name = name2;
        }

        String body = Jsoup.clean(okexDetail.getBody(), Whitelist.basic());
        Document document = Jsoup.parse(body, "UTF-8");
        Element element = document.body();

        //简介
        String abstractInfo = "";
        //官方网站
        String homeUrl = "";
        //白皮书
        String pagerUrl = "";

        Elements children = element.children();
        String text;
        for (Element child : children) {
            text = child.text();
            if (StringUtils.isBlank(text.replaceAll(" ", ""))) {
                continue;
            }

            if ((text.contains("官网") || text.contains("官方网站") || text.contains("链接")) && text.contains("白皮书")) {
                Elements elements = child.select("a");
                if (elements != null) {
                    homeUrl = elements.first().attr("href");
                    pagerUrl = elements.last().attr("href");
                }
                continue;
            } else if (text.contains("官网") || text.contains("官方网站") || text.contains("链接")) {
                Elements elements = child.select("a");
                if (elements != null) {
                    homeUrl = elements.first().attr("href");
                }
                continue;
            } else if (text.contains("白皮书")) {
                Elements elements = child.select("a");
                if (elements != null) {
                    pagerUrl = elements.first().attr("href");
                }
                continue;
            }

            abstractInfo += text.trim().replaceAll(" ", "");
        }

        ScrapyObj obj = new ScrapyObj();
        obj.setName(name);
        obj.setPagerUrl(pagerUrl);
        obj.setHomeUrl(homeUrl);
        obj.setAbstractInfo(abstractInfo);

        FileUtil.write(obj.toString(), "/Users/marico/Desktop/binance.txt");
    }
}
