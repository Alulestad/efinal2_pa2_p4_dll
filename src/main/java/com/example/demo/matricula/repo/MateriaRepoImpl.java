package com.example.demo.matricula.repo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.demo.matricula.repo.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Transactional
@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MateriaRepoImpl implements IMateriaRepo {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Materia materia) {
		this.entityManager.persist(materia);
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Materia seleccionarPorCodigo(String codigo) {
		TypedQuery<Materia> query=this.entityManager.createQuery("select m from Materia m where m.codigo=:dato",Materia.class);
		query.setParameter("dato", codigo);
		
		return query.getSingleResult();
	}
	
	
	
	
}
