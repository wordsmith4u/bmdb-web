package com.bmdb.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmdb.business.MovieGenre;

public interface MovieGenreRepo extends JpaRepository<MovieGenre, Integer> {

}
