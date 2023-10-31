package br.com.yuri.padlipskas.Verzel.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.yuri.padlipskas.Verzel.models.Veiculo;

public interface VeiculoRepository extends MongoRepository<Veiculo, String>{

}
