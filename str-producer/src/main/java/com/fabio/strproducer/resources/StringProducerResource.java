package com.fabio.strproducer.resources;

import com.fabio.strproducer.services.StringProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/producer")
public class StringProducerResource {
    //Instancia o StringProducerService
    private final StringProducerService producerService;

    @PostMapping
    //Cria um novo endpoint
    public ResponseEntity<?> sendMessage(@RequestBody String message) {//Recebe uma mensagem
        producerService.sendMessage(message);//Envia a mensagem
        return ResponseEntity.status(HttpStatus.CREATED).build();//Retorna o status 201
    }
}
