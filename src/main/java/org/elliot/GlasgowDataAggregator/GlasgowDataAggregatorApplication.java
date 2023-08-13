package org.elliot.GlasgowDataAggregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "classpath:application-local.yml")
public class GlasgowDataAggregatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlasgowDataAggregatorApplication.class, args);
	}

}
