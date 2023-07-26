package com.example.projet.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projet.entities.User;



public interface UserRepository extends JpaRepository<User, Long> {

}
