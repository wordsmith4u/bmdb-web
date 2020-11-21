package com.bmdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import com.bmdb.business.MovieGenre;
import com.bmdb.db.MovieGenreRepo;

@CrossOrigin
@RestController
@RequestMapping("/movie-genres")
public class MovieGenreController {

	@Autowired
	private MovieGenreRepo movieGenreRepo;

	// list all movie genres
	@GetMapping("/")
	public List<MovieGenre> getAllMovieGenre() {
		return movieGenreRepo.findAll();
	}

	// get movie genre by id
	@GetMapping("/{id}")
	public Optional<MovieGenre> getMovieGenre(@PathVariable int id) {
		Optional<MovieGenre> m = movieGenreRepo.findById(id);
		if (m.isPresent()) {
			return m;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie Genre not found");
		}
	}

	// add a movie genre
	@PostMapping("/")
	public MovieGenre addMovieGenre(@RequestBody MovieGenre m) {
		return movieGenreRepo.save(m);
	}

	// update a movie genre
	@PutMapping("/")
	public MovieGenre updateMovieGenre(@RequestBody MovieGenre m) {
		return movieGenreRepo.save(m);
	}

	// delete a movie genre
	@DeleteMapping("/{id}")
	public Optional<MovieGenre> deleteMovieGenre(@PathVariable int id) {
		Optional<MovieGenre> m = movieGenreRepo.findById(id);
		if (m.isPresent()) {
			movieGenreRepo.deleteById(id);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie Genre not found.");
		}
		return m;
	}

}
