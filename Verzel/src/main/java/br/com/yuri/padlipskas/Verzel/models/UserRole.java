package br.com.yuri.padlipskas.Verzel.models;

public enum UserRole {
	
	ADMIN("ADMIN"),
	USER("user");
	
	private String role;
	
	UserRole(String role){
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}

}
