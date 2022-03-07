package com.plaxa.spring_course.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequiredArgsConstructor
public class RabbitTestController {

    Logger logger = LoggerFactory.getLogger(RabbitTestController.class);
    private final AmqpTemplate template;

    @PostMapping("/emit")
    public ResponseEntity<String> emit(@RequestBody String message) {
        logger.info("Emit to myQueue");
        for (int i = 0; i < 10; i++) {
            template.convertAndSend("myQueue", ThreadLocalRandom.current().nextInt());
        }
//        template.convertAndSend("myQueue", message);
        return ResponseEntity.ok("Success emit to queue");
    }
}
