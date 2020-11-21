package com.bmdb.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmdb.business.Genre;

public interface GenreRepo extends JpaRepository<Genre, Integer> {

}


