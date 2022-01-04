package com.dwibagus.log.service.controller;

import com.dwibagus.log.service.kafka.KafkaConsumerLog;
import com.dwibagus.log.service.kafka.KafkaProducerLog;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/log")
@RequiredArgsConstructor
public class KafkaController {

    @Autowired
    private KafkaConsumerLog consumerLog;

    @Autowired
    private KafkaProducerLog producerLog;

    @PostMapping("/send/log")
    public void sendLog(@RequestBody String data) {
        producerLog.produce(data);
    }

    @GetMapping("/receive/log")
    public List<String> receiveLog() {
        return KafkaConsumerLog.messages;
    }


    public KafkaConsumerLog getConsumer() {
        return consumerLog;
    }

    public void setConsumer(KafkaConsumerLog consumer) {
        this.consumerLog = consumer;
    }

    public KafkaProducerLog getProducer() {
        return producerLog;
    }

    public void setProducer(KafkaProducerLog producer) {
        this.producerLog = producer;
    }
}
