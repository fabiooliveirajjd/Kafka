package com.fabio.strproducer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StringProducerService {
    //Instancia o KafkaTemplate
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {//Recebe uma mensagem
        kafkaTemplate.send("str-topic", message);//Envia a mensagem para o tópico str-topic
    }
}
