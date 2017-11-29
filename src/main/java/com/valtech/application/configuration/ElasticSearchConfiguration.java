package com.valtech.application.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.InetAddress;

@Configuration
public class ElasticSearchConfiguration {

	@Bean(destroyMethod = "close")
	public Client client() throws IOException, InterruptedException {

		String esHosts = "localhost";
		int esPorts = 9300;
		final String clusterName = "songdelivery";
		System.out.println("Using external Elasticsearch node cluster name");
		final Settings tSettings = Settings.builder()
		                                   .put("cluster.name", clusterName)
		                                   .put("client.transport.sniff", true)
		                                   .build();

		TransportClient client = new PreBuiltTransportClient(tSettings).addTransportAddress(
									new TransportAddress(InetAddress.getByName(esHosts), esPorts));

		return client;
	}

	@Bean
	public ObjectMapper objectMapper() {
		final ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper;
	}
}
