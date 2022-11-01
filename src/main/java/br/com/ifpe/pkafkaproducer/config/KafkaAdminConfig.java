package br.com.ifpe.pkafkaproducer.config;

import java.util.HashMap;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaAdminConfig {
	
	@Autowired
	public KafkaProperties kafka;
	
	@Bean
	public KafkaAdmin kafkaAdmin() {
		var config = new HashMap<String, Object>();
		config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafka.getBootstrapServers());
		return new KafkaAdmin(config);
	}
	
	@Bean
	public KafkaAdmin.NewTopics topicos(){
		return new KafkaAdmin.NewTopics(
			TopicBuilder.name(TopicosKafka.TOPICO_VALDEMIR).partitions(2).replicas(1).build() 
		);
	}
}
