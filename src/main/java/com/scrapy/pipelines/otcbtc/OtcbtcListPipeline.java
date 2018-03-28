package com.scrapy.pipelines.otcbtc;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.StartSchedulerContext;
import com.geccocrawler.gecco.spider.HrefBean;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by marico on 2018/2/22.
 */
@PipelineName("otcbtcListPipeline")
public class OtcbtcListPipeline implements Pipeline<OtcbtcList> {
    @Override
    public void process(OtcbtcList otcbtcList) {
        HttpRequest request = otcbtcList.getRequest();
        for (HrefBean bean : otcbtcList.getNewList()) {
            StartSchedulerContext.into(request.subRequest(bean.getUrl()));
        }

        HrefBean hrefBean = otcbtcList.getNextPage();
        if (hrefBean == null || StringUtils.isBlank(hrefBean.getUrl())) {
            return;
        }

        StartSchedulerContext.into(request.subRequest(hrefBean.getUrl()));
    }
}
