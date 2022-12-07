package com.example.bookservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConf {

    @Bean
    public NewTopic testTopic() {
        return TopicBuilder.name("books-newly-created")
                .build();
    }
}
