package com.gitub.kafka.producer.kafkaprocessor.service;

import com.gitub.kafka.producer.kafkaproducer.vo.Record;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class NumbersValidator {

    @Bean
    public Function<KStream<String, Record>, KStream<String, Record>> numbersprocessed() {
        return kstream -> kstream.filter((key, record) -> {
            Record record1 = record;
            if (Long.valueOf(record.getId()) % 2 == 0) {
                record1.setName(record1.getName() + " Identified as EVEN");
                System.out.println("EVEN Number -> " + record);
            } else {
                record1.setName(record1.getName() + " Identified as ODD");
                System.out.println("ODD Number -> " + record);
            }
            return true;
        });
    }


}
