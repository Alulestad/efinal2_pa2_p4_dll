package com.example.demo.matricula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.matricula.repo.modelo.Estudiante;
import com.example.demo.matricula.repo.modelo.Materia;
import com.example.demo.matricula.repo.modelo.Matricula;
import com.example.demo.matricula.repo.modelo.dto.MatriculaDTO;
import com.example.demo.matricula.service.IEstudianteService;
import com.example.demo.matricula.service.IMateriaService;
import com.example.demo.matricula.service.IMatriculaService;

@Controller
@RequestMapping(value = "/materias")
public class MateriaController {
	
	@Autowired
	private IMateriaService iMateriaService;
	
	@GetMapping(value = "/iniciarRegistro")
	public String inicarRegistro(Materia materia) {
		
		
		
		return "vistaForumarioRegistroMateria";
	}
	
	@PostMapping(value = "/registrar")
	public String registrar(Materia materia) {
		
		this.iMateriaService.guardar(materia);
		
		return "redirect:/materias/iniciarRegistro";
	}
	

	
}
