package com.ps.psexamedaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ps.psexamedaw.model.Cadeia;
import com.ps.psexamedaw.model.TipoDeCrime;
import com.ps.psexamedaw.repository.CadeiaRepository;
import com.ps.psexamedaw.repository.TipoDeCrimeRepository;

@Controller
public class CadeiaController {
	
	@Autowired
	private CadeiaRepository cr;
	@Autowired
	private TipoDeCrimeRepository tdcr;
	
	@GetMapping("/registrarCadeia")
	public String registrarCadeia() {
		return "cadeia/formRegistrar";
	}
	
	@PostMapping("/registrarCadeia")
	public String registrarCadeia(Cadeia cadeia) {
		cr.save(cadeia);
		return "redirect:/registrarCadeia";
	}
	
	@GetMapping("/listarCadeias")
	public ModelAndView listarCadeias() {
		ModelAndView mv =new ModelAndView("index");
		Iterable<Cadeia> cadeias = cr.findAll();
		mv.addObject("cadeias", cadeias);
		return mv;
		
	}
	
	@RequestMapping("/detalhesCadeia/{id}")
	public ModelAndView detalhesEvento(@PathVariable("id") long id) {
		
		
		Cadeia cadeia=cr.findById(id);
		ModelAndView mv=new ModelAndView("cadeia/detalhesCadeia");
		mv.addObject("cadeia",cadeia);
		
		Iterable<TipoDeCrime> tiposDeCrime= tdcr.findAll();
		mv.addObject("tiposDeCrime", tiposDeCrime);
		
		/*Iterable<Convidado> convidados = cr.findByEvento(evento);
		mv.addObject("convidados", convidados); */
		return mv;
	}

}
