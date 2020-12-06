package org.polytec.vermeg.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractHibernateDAO<T extends Serializable> {

	private Class<T> clazz;

	@Autowired
	private SessionFactory sessionFactory;

	public void setClazz(Class<T> clazzToSet) {
		clazz = clazzToSet;
	}

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public T findOne(int id) {
		return ((T) getCurrentSession().get(clazz, id));
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return getCurrentSession().createQuery("from " + clazz.getName()).list();
	}

	public void save(T entity) {
		getCurrentSession().persist(entity);
	}

	@SuppressWarnings("unchecked")
	public T update(T entity) {
		return (T) getCurrentSession().merge(entity);
	}

	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}

	public void deleteById(int id) {
		final T entity = findOne(id);
		delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<T> executeQuerySelect(String sql) {
		List<T> l = sessionFactory.getCurrentSession().createQuery(sql).list();
		return l;
	}

}
