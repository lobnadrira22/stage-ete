package com.example.projet;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.projet.entities.Candidat;
import com.example.projet.entities.Employeur;
import com.example.projet.repos.CandidatRepository;
import com.example.projet.repos.EmployeurRepository;

@SpringBootTest
class ProjetApplicationTests {

	@Autowired
	private CandidatRepository candidatrepo;
	
	@Test
	public void testCreateCandidate() {
		Candidat c1 = new Candidat("ben ahmed","maya","photo","55894254","maya@gmail.com","hhhh","dossier",14524512L,"cv");
		candidatrepo.save(c1);
	
	}
	/*@Test
	public void testFindEmployeur() {
		 Employeur emp1 = employeurrepository.findById(1).get();
		 System.out.print(emp1);
	}*/
	
	/*@Test
	public void testDeleteEmployeur() {
		employeurrepository.deleteById(1);
	}*/
	
	/*@Test
	public void testUpdateEmployeur() {
		Employeur em = employeurrepository.findById(3).get();
		em.setNom("ben jemaa");
		em.setPrenom("mahdi");
		em.setEmail("mahdibenjem@gmail.com");
		em.setNomentreprise("weavelines");
		
		employeurrepository.save(em);
		System.out.println(em);
	}/*
	/*@Test
	public void testFindALLEmployeur() {
		List<Employeur> emps = employeurrepository.findAll();
		for(Employeur ep:emps)
			System.out.println(ep);
	}*/

}
