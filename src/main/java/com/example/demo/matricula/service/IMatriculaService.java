package com.example.demo.matricula.service;

import java.util.List;

import com.example.demo.matricula.repo.modelo.Matricula;
import com.example.demo.matricula.repo.modelo.dto.MatriculaDTO;
import com.example.demo.matricula.repo.modelo.extras.MultipleMatricula;

public interface IMatriculaService {

	public List<MatriculaDTO> reporte();

	public void matriculacionParalela(MultipleMatricula multipleMatricula);
	
	public void matricularConCedulaCodigo(String cedula, String codigo, Matricula matricula);
	
}
