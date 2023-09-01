package com.example.demo.matricula.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.matricula.repo.modelo.Estudiante;
import com.example.demo.matricula.repo.modelo.Materia;
import com.example.demo.matricula.repo.modelo.dto.MatriculaDTO;
import com.example.demo.matricula.repo.modelo.extras.MultipleMatricula;
import com.example.demo.matricula.service.IEstudianteService;
import com.example.demo.matricula.service.IMateriaService;
import com.example.demo.matricula.service.IMatriculaService;

@Controller
@RequestMapping(value = "/matriculas")
public class MatriculaController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(MatriculaController.class);

	@Autowired
	private IMatriculaService iMatriculaService;
	
	@GetMapping(value = "/iniciarReporte")
	public String iniciarReporte(MatriculaDTO matriculaDTO, Model model) {
		
		List<MatriculaDTO> matriculas= this.iMatriculaService.reporte();
		
		model.addAttribute("reporteModel",matriculas);
		
		return "vistaReporteMatriculas";
	}
	
	
	
	
	@GetMapping(value = "/iniciarMatricula")
	public String iniciarMatricula(MultipleMatricula multipleMatricula) {
		
		
		
		return "vistaForumarioRegistroMatricula";
	}
	
	@PostMapping(value = "/matricular")
	public String matricular(MultipleMatricula multipleMatricula) {
		
		LOGGER.info(" Controler: MultipleMatricula: "+multipleMatricula);
		
		this.iMatriculaService.matriculacionParalela(multipleMatricula);
		
		return "redirect:/matriculas/iniciarMatricula";
	}
	
	
}
