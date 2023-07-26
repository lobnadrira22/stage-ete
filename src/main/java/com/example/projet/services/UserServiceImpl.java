package com.example.projet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.projet.entities.User;

import com.example.projet.repos.UserRepository;

public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userrep;
	@Override
	
	public User saveUser(User user) {
		return userrep.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userrep.save(user);
	}

	@Override
	public void deleteUser(User user) {
		userrep.delete(user);
		
	}

	@Override
	public void deleteUserById(Long id) {
		userrep.deleteById(id);
		
	}

	@Override
	public User getUser(Long id) {
		return userrep.findById(id).get();
	}

	@Override
	public List<User> getAllUsers() {
		return userrep.findAll();
	}
	

}
