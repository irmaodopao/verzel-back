package br.com.yuri.padlipskas.Verzel.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.yuri.padlipskas.Verzel.models.Admin;

public interface AdminRepository extends MongoRepository<Admin, String>{

}
