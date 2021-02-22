package com.linkedin.metadata.kafka.config;

import com.linkedin.metadata.builders.search.RegisteredIndexBuilders;
import com.linkedin.metadata.builders.search.SnapshotProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ElasticSearchConfig {

    @Bean
    public SnapshotProcessor snapshotProcessor() {
        return new SnapshotProcessor(RegisteredIndexBuilders.REGISTERED_INDEX_BUILDERS);
    }
}
