package com.bmdb.db;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmdb.business.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	Optional<User> findByUserNameAndPassword(String userName, String password);

}
