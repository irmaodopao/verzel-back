package br.com.yuri.padlipskas.Verzel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yuri.padlipskas.Verzel.models.Veiculo;
import br.com.yuri.padlipskas.Verzel.repositories.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository repo;
	
	public Veiculo addVeiculo(Veiculo veiculo) {
		return repo.save(veiculo);
	}
	
	public List<Veiculo> getAllVeiculo() {
		return repo.findAll();
	}
	
	public Veiculo getVeiculoById(String id) {
		return repo.findById(id).get();
	}
	
	public Veiculo updateVeiculo(Veiculo veiculo) {
		Veiculo veiculoAux = repo.findById(veiculo.getId()).get();
		veiculoAux.setId(veiculo.getId());
		veiculoAux.setNome(veiculo.getNome());
		veiculoAux.setMarca(veiculo.getMarca());
		veiculoAux.setModelo(veiculo.getModelo());
		veiculoAux.setFoto(veiculo.getFoto());
		veiculoAux.setValor(veiculo.getValor());
		repo.save(veiculoAux);
		return veiculoAux;
	}
	
	public Veiculo deleteVeiculo(String id) {
		Veiculo veiculo = repo.findById(id).get();
		repo.delete(veiculo);
		return veiculo;
	}

}
