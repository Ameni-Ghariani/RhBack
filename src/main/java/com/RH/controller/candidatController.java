package com.RH.controller;



	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestParam;
   import org.springframework.web.bind.annotation.RestController;

	import com.RH.repository.candidatRepository;

import com.RH.model.Candidat;

	@RestController
	@RequestMapping("/candidat")
	public class candidatController {
	   
		@Autowired
		private candidatRepository candidatRepository  ;
		@GetMapping("/all")
		public  List<Candidat> getAllCandidat (){
			System.out.println("hello");

			return candidatRepository.findAll();
			}
		//build create candidat RestApi
		@PostMapping("/create")
		public Candidat createCandidat(  @RequestBody Candidat c){
			return candidatRepository.save(c) ;
		}
		 // build get candidat by id REST API
	    @GetMapping("/candidat/{id}")
	    public ResponseEntity<Candidat> getCandidateById(@PathVariable  long id){
	        Candidat c1 = candidatRepository.findById(id)
	                .orElseThrow();
	        return ResponseEntity.ok(c1);
	    }
	    @PutMapping("/update/{id}")
	    public ResponseEntity<Candidat> updateCandidat(@PathVariable long id,@RequestBody Candidat candDetails) {
	        Candidat updatec= candidatRepository.findById(id)
	                .orElseThrow();

	        updatec.setFirstName(candDetails.getFirstName());
	        updatec.setLastName(candDetails.getLastName());
	        updatec.setEmail(candDetails.getEmail());
	        updatec.setGender(candDetails.getGender());
	        updatec.setCities(candDetails.getCities());
	        updatec.setNumber(candDetails.getNumber());
	        updatec.setCv(candDetails.getCv());
	        updatec.setStatut(candDetails.getStatut()) ;
	        
	        
	        

	        candidatRepository.save(updatec);

	        return ResponseEntity.ok(updatec);
	    }
	    
	    // build delete candidat REST API
	    @DeleteMapping("/remove/{id}")
	    public ResponseEntity<HttpStatus> deleteCandidat(@PathVariable long id){

	        Candidat candidat = candidatRepository.findById(id).orElseThrow() ;
	    
	       
	        candidatRepository.delete(candidat);

	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	    }

	}


