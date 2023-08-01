package com.example.projet.services;
import java.util.List;

import com.example.projet.entities.Admin;


public interface AdminService {
	
	


		Admin saveAdmin(Admin admin);
		Admin updateAdmin(Admin admin);
		void deleteAdmin(Admin admin);
		void deleteAdminById(int id);
		Admin getAdmin(Long adminId);
		List<Admin> getAllAdmins();
		Admin getAdmin(int id);

	


}
