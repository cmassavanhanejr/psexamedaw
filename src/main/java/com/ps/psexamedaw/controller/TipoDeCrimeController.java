package com.ps.psexamedaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ps.psexamedaw.model.TipoDeCrime;
import com.ps.psexamedaw.repository.TipoDeCrimeRepository;


@Controller
public class TipoDeCrimeController {

	@Autowired
	private TipoDeCrimeRepository tdcr;
	
	@GetMapping("/registrarTipoDeCrime")
	public ModelAndView registrarCadeia() {
		ModelAndView mv=new ModelAndView("tipoDeCrime/formRegistrar");
		Iterable<TipoDeCrime> tipoDeCrime=tdcr.findAll();
		mv.addObject("tiposDeCrime", tipoDeCrime);
		return mv;
	}
	
	@PostMapping("/registrarTipoDeCrime")
	public String registrarCadeia(TipoDeCrime tipoDeCrime) {
		tdcr.save(tipoDeCrime);
		
		return "redirect:/registrarTipoDeCrime";
		
	}
	
	
}
