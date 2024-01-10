package com.fabio.strproducer.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;

@RequiredArgsConstructor
@Configuration
public class KafkaAdminConfig {
    //Instancia o KafkaProperties
    public final KafkaProperties properties;


    @Bean
    //Cria um novo KafkaAdmin
    public KafkaAdmin kafkaAdmin() {
        var configs = new HashMap<String, Object>();//Cria um HashMap
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");//Adiciona o endereço do Kafka
        return new KafkaAdmin(configs);//Retorna o KafkaAdmin
    }

    @Bean
    //Cria um novo tópico
    public KafkaAdmin.NewTopics topics() {
        return new KafkaAdmin.NewTopics(//Retorna um novo tópico
                //Cria um novo tópico com o nome str-topic, 2 partições e 1 réplica
                TopicBuilder.name("str-topic").partitions(2).replicas(1).build());
    }
}
