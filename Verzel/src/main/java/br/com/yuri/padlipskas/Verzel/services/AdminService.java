package br.com.yuri.padlipskas.Verzel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.yuri.padlipskas.Verzel.dtos.AdminDTO;
import br.com.yuri.padlipskas.Verzel.models.Admin;
import br.com.yuri.padlipskas.Verzel.repositories.AdminRepository;

@Service
public class AdminService implements UserDetailsService{
	
	@Autowired
	private AdminRepository repo;
	
	public Admin addAdm(Admin adm) {
		return repo.save(adm);
	}
	
	public List<Admin> getAllAdms() {
		return repo.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repo.findByLogin(username);
	}
	
	public boolean isLogin(AdminDTO dto) {
		if(this.repo.findByLogin(dto.login()) != null) {
			return true;
		}
		return false;
	}
}
