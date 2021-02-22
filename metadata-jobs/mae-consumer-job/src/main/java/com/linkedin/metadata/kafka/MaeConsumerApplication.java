package com.linkedin.metadata.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.elasticsearch.rest.RestClientAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
@SpringBootApplication(exclude = {RestClientAutoConfiguration.class})
@ComponentScan(basePackages = {"com.linkedin.metadata.kafka", "com.linkedin.metadata.utils.elasticsearch"})
public class MaeConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaeConsumerApplication.class, args);
    }

}
