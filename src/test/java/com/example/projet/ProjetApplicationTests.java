package com.example.projet;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.projet.entities.Employeur;
import com.example.projet.repos.EmployeurRepository;

@SpringBootTest
class ProjetApplicationTests {

	@Autowired
	private EmployeurRepository employeurrepository;
	
	@Test
	public void testCreateEmployeur() {
		Employeur emp = new Employeur("ben ahmed ","mohamed","cynoia","cynoiaemp@gmail.com","jjj");
	    employeurrepository.save(emp);
	
	}
	@Test
	public void testFindEmployeur() {
		 Employeur emp1 = employeurrepository.findById(1).get();
		 System.out.print(emp1);
	}
	
	@Test
	public void testDeleteEmployeur() {
		employeurrepository.deleteById(1);
	}
	
	@Test
	public void testUpdateEmployeur() {
		Employeur em = employeurrepository.findById(1).get();
		em.setNom("mahmoud");
		employeurrepository.save(em);
		System.out.println(em);
	}
	@Test
	public void testFindALLEmployeur() {
		List<Employeur> emps = employeurrepository.findAll();
		for(Employeur ep:emps)
			System.out.println(ep);
	}

}
