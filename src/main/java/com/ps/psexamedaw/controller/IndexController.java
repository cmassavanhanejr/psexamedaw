package com.ps.psexamedaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ps.psexamedaw.model.Cadeia;
import com.ps.psexamedaw.repository.CadeiaRepository;

@Controller
public class IndexController {
	
	@Autowired
	CadeiaRepository cr;
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mv=new ModelAndView("index");
		Iterable<Cadeia> cadeias=cr.findAll();
		mv.addObject("cadeias",cadeias);
		return mv;
	}

}
