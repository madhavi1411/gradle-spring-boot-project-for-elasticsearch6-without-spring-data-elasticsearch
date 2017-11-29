package com.valtech.application.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.valtech.application.entity.Song;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by madhavilatha.a on 29/11/17.
 */

@Repository
public class SongRepositoryImpl extends BaseESRepository implements SongRepository {


	@Override
	public Song findById(Long id) {
		GetResponse response = getEsClient().prepareGet().setIndex("song").setId(String.valueOf(id)).execute().actionGet();

		return convertToSong(response.getSourceAsBytes());
	}

	@Override
	public void save(Song song) throws JsonProcessingException {
		String bytes = getObjectMapper().writeValueAsString(song);

		getEsClient().admin().indices().prepareDelete("song").execute().actionGet();

		IndexResponse indexResponse = getEsClient().prepareIndex("song", "song", String.valueOf(song.getId())).setSource(bytes, XContentType
				.JSON).get();
		int status = indexResponse.status().getStatus();

		System.out.println("status of save: " + status);
	}
}
