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
import org.springframework.web.bind.annotation.RestController;

import com.RH.repository.posteRepository;

import com.RH.model.Candidat;
import com.RH.model.Poste;


@RestController
@RequestMapping("/api")
public class posteController {
   
	@Autowired
	private posteRepository  PosteRepository ;
	@GetMapping("/all")
	public  List<Poste> getAllPoste (){
		
		return PosteRepository.findAll();
		}
	//build create poste RestApi
	@PostMapping("/create")
	public Poste createPoste ( @RequestBody Poste p){
		return PosteRepository.save(p) ;
	}
	 // build get employee by id REST API
    @GetMapping("/poste/{id}")
    public ResponseEntity<Poste> getPosteeById(@PathVariable  long id){
    	 Poste p1 = PosteRepository.findById(id).orElseThrow();
	        return ResponseEntity.ok(p1);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Poste> updateEmployee(@PathVariable long id,@RequestBody Poste posteDetails) {
        Poste updateposte= PosteRepository.findById(id)
                .orElseThrow();

        updateposte.setCities(posteDetails.getCities());
        updateposte.setEducation(posteDetails.getEducation());
        updateposte.setExperience(posteDetails.getExperience());
        updateposte.setPositionType(posteDetails.getPositionType());
        updateposte.setTitle(posteDetails.getTitle());

        PosteRepository.save(updateposte);

        return ResponseEntity.ok(updateposte);
    }
    
    // build delete employee REST API
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<HttpStatus> deletePoste(@PathVariable long id){

        Poste poste = PosteRepository.findById(id)
                .orElseThrow();

        PosteRepository.delete(poste);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
