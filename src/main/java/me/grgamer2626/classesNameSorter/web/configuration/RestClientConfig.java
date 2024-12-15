package me.grgamer2626.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
