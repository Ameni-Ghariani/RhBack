package com.RH.model;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import org.springframework.lang.NonNull;
@Entity 
@Table(name="postes")
public class Poste {
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id ;
	
	@Column(name="cities",  nullable=false)
    String cities;
	
	@Column(name="education" ,  nullable=false)
    String education ;
	
	@Column(name="experience",  nullable=false)
    String experience ;
	
	@Column(name="position",  nullable=false )
    String positionType ;
	
	@Column(name="title",  nullable=false)
	
    String title ;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "Poste_Candidat", joinColumns = @JoinColumn(name = "Poste_id"), 
		inverseJoinColumns = @JoinColumn(name = "Candidat_id" ) )
	private Set<Candidat> candidat = new HashSet<>();
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCities() {
		return cities;
	}

	public void setCities(String cities) {
		this.cities = cities;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getPositionType() {
		return positionType;
	}

	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}

	public String getTitle() {
		return title;
	}

	public Set<Candidat> getCandidat() {
		return candidat;
	}

	public void setCandidat(Set<Candidat> candidat) {
		this.candidat = candidat;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Poste(String cities, String education, String experience, String positionType, String title) {
		super();
		this.cities = cities;
		this.education = education;
		this.experience = experience;
		this.positionType = positionType;
		this.title = title;
	}
	
	public Poste() {}
	
	
	
 
 
 
}
