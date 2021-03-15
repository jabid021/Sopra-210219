package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Client extends Personne {

	
	private int age;
	@Column(name="birthdate")
	private LocalDate naissance;
	
	public Client() {
	}

	public Client(String nom,String prenom,int age, String naissance) {
		super(nom,prenom);
		this.age = age;
		this.naissance = LocalDate.parse(naissance);
		
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getNaissance() {
		return naissance;
	}

	public void setNaissance(String naissance) {
		this.naissance = LocalDate.parse(naissance);
	}

	@Override
	public String toString() {
		return "Client [age=" + age + ", naissance=" + naissance + "]";
	}
	
	
}
