package com.gitub.kafka.producer.kafkaproducer.controller;

import com.gitub.kafka.producer.kafkaproducer.service.NumberProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerRequestController {

    @Autowired
    private NumberProducerService numberProducerService;

    /**
     * push all the numbers between start and end along with some random name
     * @param start
     * @param end
     * @return
     */
    @GetMapping("/produce")
    public ResponseEntity produceDataToKafka(@RequestParam(name="start") Long start, @RequestParam(name="end") Long end) {
        numberProducerService.publishNumbers(start, end);
        return ResponseEntity.ok("SUCCESS");
    }

}
