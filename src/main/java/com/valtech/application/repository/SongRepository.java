package com.valtech.application.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.valtech.application.entity.Song;
//import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by madhavilatha.a on 29/11/17.
 */
public interface SongRepository {
	Song findById(Long id);

	void save(Song song) throws JsonProcessingException;
}
