package com.valtech.application;

import com.valtech.application.entity.Song;
import com.valtech.application.service.SongService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWithEs6ApplicationTests {

	@Autowired
	private SongService songService;

	@Test
	public void testSave() {
		songService.save();
	}

	@Test
	public void testFindById() {
		Song song = songService.findById();

		assertThat(song.getId(), is(12L));
		assertThat(song.getTitle(), is("my first poc song"));
	}

}
