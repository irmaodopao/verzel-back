package br.com.yuri.padlipskas.Verzel.dtos;

import br.com.yuri.padlipskas.Verzel.models.UserRole;

public record AdminDTO(String login, String senha, UserRole role) {

}
