package com.kafkatutoria.kafkaproject.controller;

import com.kafkatutoria.kafkaproject.consumer.KafkaDatabaseConsumer;
import com.kafkatutoria.kafkaproject.producer.WikimediaChangesProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/message/broker")
public class MessageBrokerController {
    @Autowired
    private WikimediaChangesProducer wikimediaChangesProducer;
    @Autowired
    private KafkaDatabaseConsumer kafkaDatabaseConsumer;
    @GetMapping("/start")
    public ResponseEntity<?> startBoroker() throws InterruptedException {
        wikimediaChangesProducer.sendMessage();
        return ResponseEntity.ok("Service started");
    }
    @GetMapping("/get")
    public ResponseEntity<?> getBroker() throws InterruptedException {
//        kafkaDatabaseConsumer.consume();
        return ResponseEntity.ok("Service started");
    }
}
