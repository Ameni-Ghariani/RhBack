package com.RH.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;

import com.RH.model.Candidat;
public interface candidatRepository extends JpaRepository <Candidat , Long> {

}
