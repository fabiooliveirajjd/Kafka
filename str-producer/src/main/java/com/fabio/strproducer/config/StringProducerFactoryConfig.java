package com.fabio.strproducer.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;

@RequiredArgsConstructor
@Configuration
public class StringProducerFactoryConfig {
    //Instancia o KafkaProperties
    private final KafkaProperties properties;

    @Bean
    //Cria um novo ProducerFactory
    public ProducerFactory<String, String> producerFactory() {
        var configs = new HashMap<String, Object>();//Cria um HashMap
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());//Adiciona o endereço do Kafka
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);//Adiciona o serializador da chave
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);//Adiciona o serializador do valor
        return new DefaultKafkaProducerFactory<>(configs);//Retorna o ProducerFactory
    }

    @Bean
    //Cria um novo KafkaTemplate
    public KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> producerFactory) {
        return new KafkaTemplate<>(producerFactory());//Retorna o KafkaTemplate
    }


}
