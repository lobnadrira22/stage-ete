package com.example.projet.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projet.entities.Admin;
import com.example.projet.repos.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	AdminRepository adminrep;
	@Override
	
	public Admin saveAdmin(Admin admin) {
		return adminrep.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		return adminrep.save(admin);
	}

	
	@Override
	public void deleteAdmin(Admin admin) {
		adminrep.delete(admin);
		
	}

	@Override
	public void deleteAdminById(int id) {
		adminrep.deleteById((long) id);
		
	}

	@Override
	public Admin getAdmin(int id) {
		return adminrep.findById((long) id).get();
	}

	@Override
	public List<Admin> getAllAdmins() {
		return adminrep.findAll();
	}

	@Override
	public Admin getAdmin(Long adminId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin loginAdmin(String email, String password) {
		Admin adm = adminrep.findByEmail(email);
		if (adm != null && adm.getPassword().equals(password)) {
            return adm; /* Authentification réussie, renvoie le candidat */
        }

        return null; /* Authentification échouée */
	}

	
    @Override
	public boolean emailExists(String email) {
		 return adminrep.findByEmail(email) != null;
	}

	

}
