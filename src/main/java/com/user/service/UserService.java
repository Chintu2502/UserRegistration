package com.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.user.dto.UserDto;
import com.user.entity.User;
import com.user.repository.UserRepository;
@Service
public class UserService {
	@Autowired
	UserRepository repository;
	
	public String UserRegistration(UserDto dto)
	{
		User user=new User();
		user.setFname(dto.getFname());
		System.out.println(dto.getFname());
		user.setLname(dto.getLname());
		user.setEmail(dto.getEmail());
		System.out.println(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setUsername(dto.getUsername());
		Optional<User> obj=repository.findById(user.getEmail());
		if(obj.isPresent())
		{
			return "email already present, please try with another email.";
		}
		
		repository.save(user);
		return "user registration successfull";
		
	}
	public User ValidateUser(String email,String password)
	{
		List<User> obj=repository.findByEmailAndPassword(email, password);
		if(obj.size()==0)
		{
			return null;
		}else
		{
			return obj.get(0);
			
		}
	}
}
