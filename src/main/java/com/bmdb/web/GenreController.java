package com.bmdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.bmdb.business.Genre;
import com.bmdb.db.GenreRepo;

@CrossOrigin
@RestController
@RequestMapping("/genres")
public class GenreController {

	@Autowired
	private GenreRepo genreRepo;

	// list all genres
	@GetMapping("/")
	public List<Genre> getAllGenres() {
		return genreRepo.findAll();
	}

	// get genre by id
	@GetMapping("/{id}")
	public Optional<Genre> getGenre(@PathVariable int id) {
		Optional<Genre> g = genreRepo.findById(id);
		if (g.isPresent()) {
			return g;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Genre not found");
		}
	}

	// add a genre
	@PostMapping("/")
	public Genre addGenre(@RequestBody Genre g) {
		return genreRepo.save(g);
	}

	// update a genre
	@PutMapping("/")
	public Genre updateGenre(@RequestBody Genre g) {
		return genreRepo.save(g);
	}

	// delete a genre
	@DeleteMapping("/{id}")
	public Optional<Genre> deleteGenre(@PathVariable int id) {
		Optional<Genre> g = genreRepo.findById(id);
		if (g.isPresent()) {
			genreRepo.deleteById(id);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Genre not found.");
		}
		return g;
	}

}
