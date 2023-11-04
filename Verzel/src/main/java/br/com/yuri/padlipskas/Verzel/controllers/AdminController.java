package br.com.yuri.padlipskas.Verzel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.yuri.padlipskas.Verzel.dtos.AdminDTO;
import br.com.yuri.padlipskas.Verzel.dtos.AuthDTO;
import br.com.yuri.padlipskas.Verzel.dtos.LoginResponseDTO;
import br.com.yuri.padlipskas.Verzel.models.Admin;
import br.com.yuri.padlipskas.Verzel.repositories.AdminRepository;
import br.com.yuri.padlipskas.Verzel.services.AdminService;
import br.com.yuri.padlipskas.Verzel.services.TokenService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@Autowired
	private AdminRepository repo;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	private ResponseEntity<Admin> createAdm(@RequestBody Admin adm){
		return new ResponseEntity<Admin>(service.addAdm(adm),HttpStatus.CREATED);
	}
	
	@GetMapping
	private ResponseEntity<List<Admin>> getAllAdm(){
		return new ResponseEntity<List<Admin>>(service.getAllAdms(),HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody AuthDTO authDto) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(authDto.login(), authDto.senha());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		var token = tokenService.generateToken((Admin) auth.getPrincipal());
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
	
	@PostMapping("/registrar")
	public ResponseEntity registrar(@RequestBody AdminDTO adm) {
		if(service.isLogin(adm)) {
			return  ResponseEntity.badRequest().build();
		}
		String senhaCriptografada = new BCryptPasswordEncoder().encode(adm.senha());
		Admin adminAux = new Admin(adm.login(),senhaCriptografada,adm.role());
		this.repo.save(adminAux);
		return ResponseEntity.ok().build();
	}

}
