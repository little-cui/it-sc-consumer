package com.service.consumer;

import org.apache.servicecomb.foundation.common.utils.BeanUtils;
import org.apache.servicecomb.foundation.common.utils.Log4jUtils;
import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class ConsumerApplication {
    private static Logger logger = LoggerFactory.getLogger(ConsumerApplication.class);

    public static void main(String[] args) throws Exception {
        Log4jUtils.init();
        BeanUtils.init();

        RestTemplate template = RestTemplateBuilder.create();

        while (true) {
            try {
                logger.info("name = {}", template.getForObject("cse://provider/provider/helloworld?name=a", String.class));
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
            Thread.sleep(1000);
        }
    }
}
