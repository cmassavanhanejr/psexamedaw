package com.ps.psexamedaw.repository;

import org.springframework.data.repository.CrudRepository;

import com.ps.psexamedaw.model.TipoDeCrime;

public interface TipoDeCrimeRepository extends CrudRepository<TipoDeCrime, Long>{
	TipoDeCrime findById(long id);
}
