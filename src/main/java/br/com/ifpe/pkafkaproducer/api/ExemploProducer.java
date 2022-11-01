package br.com.ifpe.pkafkaproducer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.pkafkaproducer.config.TopicosKafka;
import br.com.ifpe.pkafkaproducer.servicos.ProducerService;

@RestController
@RequestMapping(value = "/producer")
public class ExemploProducer {

	@Autowired
    private ProducerService producerService;

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody String mensagem) {
    	producerService.sendMessage(TopicosKafka.TOPICO_VALDEMIR, mensagem);
    	return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
