package com.RH.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import javax.validation.constraints.*; 

//import org.hibernate.validator.constraints.Email;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name=" candidat")
public class Candidat {
	
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Column(name = "FirstName",  nullable=false)
		private String FirstName;
		
		@Column(name = "LastName",  nullable=false)
		private String LastName;
		
		@Column(name = "Email")
		@Email
		private String Email;
		
		@Column(name = "Gender",  nullable=false)
		private String Gender;
	
		@Column(name = "cities" ,  nullable=false)
		private String cities;
		
		@Column(name = "number" ,  nullable=false)
		private int number;
		
		@Column(name = "cv", nullable=false)
		private String cv;
	
		@Column(name = " statut",  nullable=false)
		private String statut;
		
	
		
		

		@ManyToMany(mappedBy = "candidat", fetch = FetchType.LAZY)
		@JsonIgnoreProperties("candidat")
		private Set<Poste> poste = new HashSet<>() ;





		public long getId() {
			return id;
		}





		public void setId(long id) {
			this.id = id;
		}





		public String getFirstName() {
			return FirstName;
		}





		public void setFirstName(String firstName) {
			FirstName = firstName;
		}





		public String getLastName() {
			return LastName;
		}





		public void setLastName(String lastName) {
			LastName = lastName;
		}





		public String getEmail() {
			return Email;
		}





		public void setEmail(String email) {
			Email = email;
		}





		public String getGender() {
			return Gender;
		}





		public void setGender(String gender) {
			Gender = gender;
		}





		public String getCities() {
			return cities;
		}





		public void setCities(String cities) {
			this.cities = cities;
		}





		public int getNumber() {
			return number;
		}





		public void setNumber(int number) {
			this.number = number;
		}





		public String getCv() {
			return cv;
		}





		public void setCv(String cv) {
			this.cv = cv;
		}





		public String getStatut() {
			return statut;
		}





		public void setStatut(String statut) {
			this.statut = statut;
		}





		public Set<Poste> getPoste() {
			return poste;
		}





		public void setPoste(Set<Poste> poste) {
			this.poste = poste;
		}





		public Candidat(String firstName, String lastName, String email, String gender, String cities, int number,
				String cv, String statut) {
			super();
			FirstName = firstName;
			LastName = lastName;
			Email = email;
			Gender = gender;
			this.cities = cities;
			this.number = number;
			this.cv = cv;
			this.statut = statut;
		}





		public Candidat() {
			super();
		}
		
		
		

	
}
