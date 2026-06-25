package com.fswt.onlinevotingsystem.entity;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Table(name="citizens")
public class Citizen {

	@Id
    @Column(name="id")
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
		}
	
	@Column(name="citizen_name")
	private String name;
	
	public String getName() {
		return name;
	}
	
	public Citizen() {
		super();
	}

	public void setName(String name) {
		this.name= name;
	}

	public Citizen(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Column(name="hasvoted")
	private Boolean hasVoted;

	public Boolean getHasVoted() {
		return hasVoted;
	}
	public void setHasVoted(Boolean hasVoted) {
		this.hasVoted = hasVoted;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
