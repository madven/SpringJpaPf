package com.example.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractDao<T extends Serializable> {

	@PersistenceContext
	private EntityManager em;

	private Class<T> entityClass;

	public AbstractDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	private Class<T> getEntityClass() {
		return this.entityClass;
	}

	public EntityManager getEntityManager() {
		return this.em;
	}

	public void create(T entity){
		getEntityManager().persist(entity);
	}

	public T update(T entity){
		return getEntityManager().merge(entity);
	}

	public void remove(T entity){
		getEntityManager().remove(getEntityManager().merge(entity));
	}

	public T find(Object id) {
		return getEntityManager().find(getEntityClass(), id);
	}

	public List<T> findAll() {
		CriteriaQuery<T> cq = getEntityManager().getCriteriaBuilder().createQuery(getEntityClass());
		cq.select(cq.from(getEntityClass()));
		return getEntityManager().createQuery(cq).getResultList();
	}

}
