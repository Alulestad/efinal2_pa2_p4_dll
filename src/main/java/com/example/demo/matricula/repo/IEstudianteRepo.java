package com.example.demo.matricula.repo;

import com.example.demo.matricula.repo.modelo.Estudiante;

public interface IEstudianteRepo {

	public void insertar(Estudiante estudiante);
	
	public Estudiante seleccionarPorCedula(String cedula);
}
