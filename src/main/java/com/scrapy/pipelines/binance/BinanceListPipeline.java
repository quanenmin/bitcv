package com.scrapy.pipelines.binance;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.StartSchedulerContext;
import com.geccocrawler.gecco.spider.HrefBean;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by marico on 2018/2/22.
 */
@PipelineName("binanceListPipeline")
public class BinanceListPipeline implements Pipeline<BinanceList> {
    @Override
    public void process(BinanceList binanceList) {
        HttpRequest request = binanceList.getRequest();
        for (HrefBean bean : binanceList.getNewList()) {
            StartSchedulerContext.into(request.subRequest(bean.getUrl()));
        }

        HrefBean hrefBean = binanceList.getNextPage();
        if (hrefBean == null || StringUtils.isBlank(hrefBean.getUrl())) {
            return;
        }

        StartSchedulerContext.into(request.subRequest(hrefBean.getUrl()));
    }
}
