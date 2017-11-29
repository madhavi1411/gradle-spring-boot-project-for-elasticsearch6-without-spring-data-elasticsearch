package com.valtech.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.valtech.application.entity.Song;
import com.valtech.application.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by madhavilatha.a on 29/11/17.
 */
@Component
public class SongService {

	@Autowired
	private SongRepository songRepository;

	public void save() {
		Song song = new Song();
		song.setId(12L);
		song.setTitle("my first poc song");

		try {
			songRepository.save(song);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	public Song findById() {
		return songRepository.findById(12L);
	}
}
