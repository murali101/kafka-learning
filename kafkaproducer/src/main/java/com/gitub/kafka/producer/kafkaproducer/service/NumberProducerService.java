package com.gitub.kafka.producer.kafkaproducer.service;

public interface NumberProducerService {
    void publishNumbers(long start, long end);
}
