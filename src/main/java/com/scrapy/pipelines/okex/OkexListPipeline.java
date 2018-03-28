package com.scrapy.pipelines.okex;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.StartSchedulerContext;
import com.geccocrawler.gecco.spider.HrefBean;
import com.scrapy.pipelines.otcbtc.OtcbtcList;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by marico on 2018/2/22.
 */
@PipelineName("okexListPipeline")
public class OkexListPipeline implements Pipeline<OkexList> {
    @Override
    public void process(OkexList okexList) {
        HttpRequest request = okexList.getRequest();
        for (HrefBean bean : okexList.getNewList()) {
            StartSchedulerContext.into(request.subRequest(bean.getUrl()));
        }

        HrefBean hrefBean = okexList.getNextPage();
        if (hrefBean == null || StringUtils.isBlank(hrefBean.getUrl())) {
            return;
        }

        StartSchedulerContext.into(request.subRequest(hrefBean.getUrl()));
    }
}
