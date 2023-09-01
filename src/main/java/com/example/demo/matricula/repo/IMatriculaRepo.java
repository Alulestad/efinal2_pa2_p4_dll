package com.example.demo.matricula.repo;

import java.util.List;

import com.example.demo.matricula.repo.modelo.Matricula;
import com.example.demo.matricula.repo.modelo.dto.MatriculaDTO;

public interface IMatriculaRepo {

	public List<MatriculaDTO> seleccionarTodosEficiente();

	public void insertar(Matricula matricula);

}
