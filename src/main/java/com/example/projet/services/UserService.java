package com.example.projet.services;
import java.util.List;
import com.example.projet.entities.User;

public interface UserService {
	
	


		User saveUser(User user);
		User updateUser(User user);
		void deleteUser(User user);
		void deleteUserById(Long id);
		User getUser(Long id);
		List<User> getAllUsers();

	


}
