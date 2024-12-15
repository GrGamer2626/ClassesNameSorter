package me.grgamer2626.classesNameSorter.usosAPI.client;

import org.springframework.web.client.RestTemplate;

public abstract class AbstractClient {
	protected final String urlBase;
	protected final RestTemplate restTemplate;
	
	public AbstractClient(String urlBase, RestTemplate restTemplate) {
		this.urlBase = "https://test.usosapi.devel.uj.edu.pl/services" + urlBase;
		this.restTemplate = restTemplate;
	}
}
