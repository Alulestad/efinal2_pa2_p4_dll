package com.example.demo.matricula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.matricula.repo.modelo.Estudiante;
import com.example.demo.matricula.service.IEstudianteService;

@Controller
@RequestMapping(value = "/estudiantes")
public class EstudianteController {
	
	@Autowired
	private IEstudianteService iEstudianteService;
	
	@GetMapping(value = "/iniciarRegistro")
	public String inicarRegistro(Estudiante estudiante) {
		
		
		
		return "vistaForumarioRegistroEstudiante";
	}
	
	@PostMapping(value = "/registrar")
	public String registrar(Estudiante estudiante) {
		
		this.iEstudianteService.guardar(estudiante);
		
		return "redirect:/estudiantes/iniciarRegistro";
	}
	
}
