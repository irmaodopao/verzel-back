package br.com.yuri.padlipskas.Verzel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yuri.padlipskas.Verzel.models.Admin;
import br.com.yuri.padlipskas.Verzel.repositories.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository repo;
	
	public Admin addAdm(Admin adm) {
		return repo.save(adm);
	}
	
	public List<Admin> getAllAdms() {
		return repo.findAll();
	}
}
