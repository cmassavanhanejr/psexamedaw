package com.ps.psexamedaw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ps.psexamedaw.model.Cadeia;

@Repository
public interface CadeiaRepository extends CrudRepository<Cadeia, Long>{

	
	Cadeia findById(long id);
}
