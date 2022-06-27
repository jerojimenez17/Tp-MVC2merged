package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Usuario extends Observable implements Serializable {
	private String username;
	private String password;
	private transient List<Contratacion> contrataciones;

	public Usuario(String username, String password) {
		this.username = username;
		this.password = password;
		this.contrataciones = new ArrayList<>();
	}

	public boolean isAdmin() {
		return true;
	}

	// Use this method to valid Login
	public boolean isValid(String username, String password) {
		return this.username.toLowerCase().equals(username.toLowerCase()) &&
				this.password.toLowerCase().equals(password.toLowerCase());
	}

	@Override
	public boolean equals(Object anotherUser) {
		return this.username.toLowerCase().equals(((Usuario) anotherUser).username.toLowerCase()) &&
				this.password.toLowerCase().equals(((Usuario) anotherUser).password.toLowerCase());

	}

	public void addContratacion(Contratacion contratacion) {
		this.contrataciones.add(contratacion);
	}

	public List<Contratacion> getContrataciones() {
		List<Contratacion> contrata = this.contrataciones;
		return contrata;
	}

	public String getUsername() {
		return username;
	}

	public String toString() {
		return "Nombre de usuario: " + this.getUsername() + "\n";
	}

	public String getPassword() {
		return this.password;
	}
}
