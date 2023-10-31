package br.com.yuri.padlipskas.Verzel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.yuri.padlipskas.Verzel.models.Veiculo;
import br.com.yuri.padlipskas.Verzel.services.VeiculoService;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
	
	@Autowired
	private VeiculoService service;
	
	
	@PostMapping
	public ResponseEntity<Veiculo> criarVeiculo(@RequestBody Veiculo veiculo){
		return new ResponseEntity<Veiculo>(service.addVeiculo(veiculo),HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Veiculo>> getAllVeiculos(){
		return new ResponseEntity<List<Veiculo>> (service.getAllVeiculo(),HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Veiculo> updateVeiculo(@RequestBody Veiculo veiculo){
		return new ResponseEntity<Veiculo>(service.updateVeiculo(veiculo),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Veiculo> deleteVeiculo(@PathVariable String id){
		return new ResponseEntity<Veiculo>(service.deleteVeiculo(id),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> getVeiculoById(@PathVariable String id){
		return new ResponseEntity<Veiculo>(service.getVeiculoById(id),HttpStatus.OK);
	}
	
	

}
