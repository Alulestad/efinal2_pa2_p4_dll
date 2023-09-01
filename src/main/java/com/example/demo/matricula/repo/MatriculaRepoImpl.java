package com.example.demo.matricula.repo;

import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.demo.matricula.repo.modelo.Matricula;
import com.example.demo.matricula.repo.modelo.dto.MatriculaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Transactional
@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MatriculaRepoImpl implements IMatriculaRepo {

	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<MatriculaDTO> seleccionarTodosEficiente() {
		
		TypedQuery<MatriculaDTO> myQuery=this.entityManager.createQuery(""
				+ "select new com.example.demo.matricula.repo.modelo.dto.MatriculaDTO(m.estudiante.cedula,m.materia.nombre,m.materia.cedulaProfesor,m.nombreHilo) "
				+ "from Matricula m",MatriculaDTO.class);
		
		
		return myQuery.getResultList();
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	//Observacion me bota que requiere la transaccion en el paralel stream sin envargo si cosnta con la misma
	//por tanto parece que cada hilo maneja una transaccion diferente por eso le 
	//intente con requires_NEW en el me´todo pero ni aun así.
	//de tal modo me veo forzado a poner requides acá.
	public void insertar(Matricula matricula) {
		this.entityManager.persist(matricula);
		
	}
	
	
	
	
	
}
