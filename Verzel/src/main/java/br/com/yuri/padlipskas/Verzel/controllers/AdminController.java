package br.com.yuri.padlipskas.Verzel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.yuri.padlipskas.Verzel.models.Admin;
import br.com.yuri.padlipskas.Verzel.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@PostMapping
	private ResponseEntity<Admin> createAdm(@RequestBody Admin adm){
		return new ResponseEntity<Admin>(service.addAdm(adm),HttpStatus.CREATED);
	}
	
	@GetMapping
	private ResponseEntity<List<Admin>> getAllAdm(){
		return new ResponseEntity<List<Admin>>(service.getAllAdms(),HttpStatus.OK);
	}

}
