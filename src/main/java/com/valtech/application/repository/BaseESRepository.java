package com.valtech.application.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.valtech.application.entity.Song;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * Created by madhavilatha.a on 29/11/17.
 */
public class BaseESRepository {

	@Autowired
	private Client esClient;

	@Autowired
	private ObjectMapper objectMapper;

	public Client getEsClient() {
		return esClient;
	}

	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	public Song convertToSong(final byte[] sourceAsBytes) {
		Song esClient;
		try {
			esClient = objectMapper.readValue(sourceAsBytes, Song.class);
		} catch (IOException iox) {
			throw new RuntimeException("En error occurred while reading EsClient entity", iox);
		}
		return esClient;
	}

}
