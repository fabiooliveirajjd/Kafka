package com.fabio.strproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {
    //Instancia o KafkaTemplate
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {//Recebe uma mensagem
        kafkaTemplate.send("str-topic", message).addCallback(
                success -> {
                    if (success != null) {
                        log.info("Send message with sucess " + message);
                        log.info("Partition " + success.getRecordMetadata().partition());
                        log.info("Offset " + success.getRecordMetadata().offset());
                    }
                    log.info("Send message with sucess " + message);
                },
                failure -> log.error("Error send message")//Imprime a mensagem de falha
        );
    }
}
