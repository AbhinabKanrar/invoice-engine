package com.risefintech.invoicechoice.engine;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.WebSocketAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = { WebSocketAutoConfiguration.class, JmxAutoConfiguration.class })
@EnableBatchProcessing
public class EngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(EngineApplication.class, args);
	}

	@Bean
	CommandLineRunner run() {
		return args -> {
			System.out.println("|||   Application Started   |||");
		};
	}

}
