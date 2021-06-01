package com.gitub.kafka.consumer.kafkaconsumer.service;

import com.gitub.kafka.producer.kafkaproducer.vo.Record;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class NumbersConsumer {

    @Bean
    public Consumer<KStream<String, Record>> numbersService() {
        return kstream -> kstream.foreach((key, record) -> {
            System.out.println("RESULT ===> " + record);
        });
    }
}
