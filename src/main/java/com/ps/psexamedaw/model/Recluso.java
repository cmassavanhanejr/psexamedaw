package com.ps.psexamedaw.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("1")
public class Recluso extends Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne
	private Cadeia cadeia;
	@ManyToOne
	private TipoDeCrime tipoDeCrime;
}
