package com.example.demo.matricula.repo.modelo.dto;

public class MatriculaDTO {

	private String cedulaEstudiante;
	private String NombreMateria;
	private String cedulaProfesor;
	private String nombreHilo;
	
	
	
	public MatriculaDTO() {
		super();
	}



	public MatriculaDTO(String cedulaEstudiante, String nombreMateria, String cedulaProfesor, String nombreHilo) {
		super();
		this.cedulaEstudiante = cedulaEstudiante;
		NombreMateria = nombreMateria;
		this.cedulaProfesor = cedulaProfesor;
		this.nombreHilo = nombreHilo;
	}


	//gets y sets
	public String getCedulaEstudiante() {
		return cedulaEstudiante;
	}



	public void setCedulaEstudiante(String cedulaEstudiante) {
		this.cedulaEstudiante = cedulaEstudiante;
	}



	public String getNombreMateria() {
		return NombreMateria;
	}



	public void setNombreMateria(String nombreMateria) {
		NombreMateria = nombreMateria;
	}



	public String getCedulaProfesor() {
		return cedulaProfesor;
	}



	public void setCedulaProfesor(String cedulaProfesor) {
		this.cedulaProfesor = cedulaProfesor;
	}



	public String getNombreHilo() {
		return nombreHilo;
	}



	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}



	@Override
	public String toString() {
		return "MatriculaDTO [cedulaEstudiante=" + cedulaEstudiante + ", NombreMateria=" + NombreMateria
				+ ", cedulaProfesor=" + cedulaProfesor + ", nombreHilo=" + nombreHilo + "]";
	}
	
	
	
	
	
	
}
