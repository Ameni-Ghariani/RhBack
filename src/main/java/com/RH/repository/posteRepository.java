package com.RH.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RH.model.Poste;

public interface posteRepository extends JpaRepository <Poste,Long>{
//all crud database methods
}
