package com.bmdb.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bmdb.business.Movie;
import com.bmdb.db.MovieRepo;

@CrossOrigin
@RestController
@RequestMapping("/movies")
public class MovieController {

	/*
	 * A controller will implement 5 CRUD methods: 1) GET ALL 2) GET BY ID 3) POST -
	 * Insert 4) PUT - Update 5) DELETE - Delete
	 */

	@Autowired
	private MovieRepo movieRepo;

	// GET ALL movies
	@GetMapping("/")
	public List<Movie> getAll() {
		return movieRepo.findAll();
	}

	// GET a movie by ID
	@GetMapping("/{id}")
	public Optional<Movie> getById(@PathVariable int id) {
		return movieRepo.findById(id);
	}

	// Add a movie
	@PostMapping("/")
	public Movie addMovie(@RequestBody Movie m) {
		m = movieRepo.save(m);
		return m;
	}

	// Update the movie
	@PutMapping("/")
	public Movie updateMovie(@RequestBody Movie m) {
		m = movieRepo.save(m);
		return m;
	}

	// Delete the movie
	@DeleteMapping("/{id}")
	public Movie deleteMovie(@PathVariable int id) {

		// Optional type will wrap a movie
		Optional<Movie> m = movieRepo.findById(id);

		// Is Present will return true if movie is found
		if (m.isPresent()) {
			movieRepo.deleteById(id);

		} else {
			System.out.println("Error - movie not found for id " + id);
		}
		return m.get();
	}
}
