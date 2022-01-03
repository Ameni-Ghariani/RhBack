package com.RH;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.RH.model.Candidat;
import com.RH.model.Poste;
import com.RH.repository.candidatRepository;
import com.RH.repository.posteRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RhApplication  implements CommandLineRunner {
	@Autowired
    private posteRepository posteRep ;
	@Autowired 
	private candidatRepository candidatRep ;
	public static void main(String[] args)  {
		SpringApplication.run(RhApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Poste poste = new Poste("sfax","cycle preparatoire","stage pfe","temps complet","front-end") ;
		Candidat c = new Candidat("Mariem","ellouze","mariemellouze@gmail.com","femme","sfax",55644899,"cv_mariem","en attante");
		Candidat c1 = new Candidat("ali","ellouze","aliellouze@gmail.com","homme","sfax",56344899,"cv_Ali","en attante");
		
		//add  candidat to poste
		
		poste.getCandidat().add(c);
		poste.getCandidat().add(c1);
		
		//add poste to candidat 
		
		c.getPoste().add(poste) ;
		c1.getPoste().add(poste);
		this.posteRep.save(poste) ;
	
		
	}
  
	

}
