package com.kubrynski.contracts.contractsdemo;

import com.kubrynski.contracts.contractsdemo.events.SystemEventsNotifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(SystemEventsNotifier.class)
public class ContractsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContractsDemoApplication.class, args);
	}
}
