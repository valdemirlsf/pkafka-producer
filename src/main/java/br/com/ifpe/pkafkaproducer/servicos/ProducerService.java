package br.com.ifpe.pkafkaproducer.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class ProducerService {
	
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String topico, String mensagem) {
      kafkaTemplate.send(topico, mensagem);
    }

}
