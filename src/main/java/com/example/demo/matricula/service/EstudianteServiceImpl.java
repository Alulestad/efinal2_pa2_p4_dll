package com.example.demo.matricula.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.demo.matricula.repo.IEstudianteRepo;
import com.example.demo.matricula.repo.modelo.Estudiante;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepo iEstudianteRepo;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void guardar(Estudiante estudiante) {
		this.iEstudianteRepo.insertar(estudiante);
		
	}
	
	
}
