package com.COC_Project.COC_project.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.COC_Project.COC_project.Model.COCDto;
import com.COC_Project.COC_project.service.CocServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class COCController {
	
	@Autowired
	private CocServiceImpl service;

	@GetMapping("/")
	public String getFprm() {
		log.info("test");
		return "coc_form";
	}
	
	@PostMapping("/generate")
	public String generateCoc(@ModelAttribute COCDto modelobj) {
		log.info(" modelobj :{}",modelobj);
		service.coc_generation(modelobj);
		return "coc_form";
	}
	
	@GetMapping("/coc")
	public String getCoc() {
		log.info("test 1");
		service.coc_bulk();
		return "coc_form";
	}
	
	
}
