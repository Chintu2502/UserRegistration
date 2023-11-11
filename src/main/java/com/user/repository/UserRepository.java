package com.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.User;

public interface UserRepository extends JpaRepository<User,String>{
	List<User> findByEmailAndPassword(String email,String password);
}
