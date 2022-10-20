package com.example.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "empresa")
public class Company {

	@Id
	@Column(name = "id_empresa")
	@GenericGenerator(name = "id_generator_company", strategy = "increment") 
	@GeneratedValue(generator = "id_generator_company")
	private Integer idCompany;
	
	private String name;
	
	private Integer rut;
	
	@OneToMany(mappedBy= "work")
	List<Person> workers;

	public Integer getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(Integer idCompany) {
		this.idCompany = idCompany;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRut() {
		return rut;
	}

	public void setRut(Integer rut) {
		this.rut = rut;
	}

	public List<Person> getWorkers() {
		return workers;
	}

	public void setWorkers(List<Person> workers) {
		this.workers = workers;
	}


}
