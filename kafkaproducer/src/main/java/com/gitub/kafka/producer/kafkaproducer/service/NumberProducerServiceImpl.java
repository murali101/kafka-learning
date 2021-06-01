package com.gitub.kafka.producer.kafkaproducer.service;

import com.gitub.kafka.producer.kafkaproducer.vo.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.stream.LongStream;

@Component
public class NumberProducerServiceImpl implements NumberProducerService {

    @Autowired
    private KafkaTemplate<String, Record> kafkaTemplate;

    private final String KAFKA_TOPIC = "numbersdata";

    @Override
    public void publishNumbers(long start, long end) {
        LongStream.range(start, end).forEach(value -> {
           Record record = new Record(String.valueOf(value), "record added " + value);
           kafkaTemplate.send(KAFKA_TOPIC, record);
            System.out.println("PUBLISHED RECORDS ==> " + record);
        });
    }
}
