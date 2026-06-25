package com.fswt.onlinevotingsystem.entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Table(name="candidates")

public class Candidate {

	 public Candidate(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Candidate() {
		super();
	}


	@Id
	 @Column(name="id")
	 private Long id;
	 
	 public Long getId() {
		 return id;
	 }
	 public void setId(Long id) {
		 this.id= id;
	 }
	 
	 @Column(name="candidate_name")
	 public  String name;
	 
	 public String getName() {
		 return name;
	 }
	 
	 
	 public Candidate(Long id, String name, Integer numberOfVotes) {
		super();
		this.id = id;
		this.name = name;
		this.numberOfVotes = numberOfVotes;
	}

	public void setName(String name) {
		 this.name = name;
	 }
	 @Column(name="numberOfVotes")
	 private Integer numberOfVotes;

	public Integer getNumberOfVotes() {
		return numberOfVotes;
	}

	public void setNumberOfVotes(Integer numberOfVotes) {
		this.numberOfVotes = numberOfVotes;
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
