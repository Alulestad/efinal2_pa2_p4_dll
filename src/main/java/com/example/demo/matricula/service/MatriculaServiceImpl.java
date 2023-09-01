package com.example.demo.matricula.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.demo.matricula.controller.MatriculaController;
import com.example.demo.matricula.repo.IEstudianteRepo;
import com.example.demo.matricula.repo.IMateriaRepo;
import com.example.demo.matricula.repo.IMatriculaRepo;
import com.example.demo.matricula.repo.modelo.Estudiante;
import com.example.demo.matricula.repo.modelo.Materia;
import com.example.demo.matricula.repo.modelo.Matricula;
import com.example.demo.matricula.repo.modelo.dto.MatriculaDTO;
import com.example.demo.matricula.repo.modelo.extras.MultipleMatricula;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MatriculaServiceImpl implements IMatriculaService {

	private static final Logger LOGGER=LoggerFactory.getLogger(MatriculaController.class);
	
	@Autowired
	private IMatriculaRepo iMatriculaRepo;
	
	@Autowired
	private IEstudianteRepo iEstudianteRepo;
	
	@Autowired
	private IMateriaRepo iMateriaRepo;

	@Override
	public List<MatriculaDTO> reporte() {
		
		return this.iMatriculaRepo.seleccionarTodosEficiente();
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void matriculacionParalela(MultipleMatricula multipleMatricula) {
		List<Matricula> matriculas= new ArrayList<>();
		
		Matricula m1= new Matricula();
		m1.setFecha(LocalDate.now());
		Materia ma1= new Materia();
		ma1.setCodigo(multipleMatricula.getCodigoMateria1());
		m1.setMateria(ma1);
		
		Matricula m2= new Matricula();
		m2.setFecha(LocalDate.now());
		Materia ma2= new Materia();
		ma2.setCodigo(multipleMatricula.getCodigoMateria2());
		m2.setMateria(ma2);
		
		
		Matricula m3= new Matricula();
		m3.setFecha(LocalDate.now());
		Materia ma3= new Materia();
		ma3.setCodigo(multipleMatricula.getCodigoMateria3());
		m3.setMateria(ma3);
		
		
		Matricula m4= new Matricula();
		Materia ma4= new Materia();
		ma4.setCodigo(multipleMatricula.getCodigoMateria4());
		m4.setMateria(ma4);
		
		matriculas.add(m1);
		matriculas.add(m2);
		matriculas.add(m3);
		matriculas.add(m4);
		
		matriculas.parallelStream().forEach((matricula)->{
			String hilo=Thread.currentThread().getName();
			matricula.setNombreHilo(hilo);
			LOGGER.info("Materia: "+matricula.getMateria());
			LOGGER.info("Estudiante: "+matricula.getEstudiante());
			this.matricularConCedulaCodigo(multipleMatricula.getCedulaEstudiante(), 
					matricula.getMateria().getCodigo(), 
					matricula);
			
		});
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void matricularConCedulaCodigo(String cedula, String codigo, Matricula matricula) {
		
		Estudiante estudiante= this.iEstudianteRepo.seleccionarPorCedula(cedula);
		Materia materia= this.iMateriaRepo.seleccionarPorCodigo(codigo);
		List<Matricula> list=new ArrayList<>();
		list.add(matricula);
		
		estudiante.setMatriculas(list);
		materia.setMatriculas(list);
		
		matricula.setEstudiante(estudiante);
		matricula.setMateria(materia);
		matricula.setFecha(LocalDate.now());
		this.iMatriculaRepo.insertar(matricula);
		
		
	}
	
	
	
	
	
}
