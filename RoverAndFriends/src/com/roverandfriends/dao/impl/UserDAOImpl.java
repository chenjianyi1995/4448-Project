package com.roverandfriends.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.roverandfriends.dao.UserDAO;
import com.roverandfriends.model.User;
import com.sun.istack.internal.logging.Logger;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	final static Logger logger = Logger.getLogger(UserDAOImpl.class);
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	/*@PersistenceContext
	public EntityManager entityManager;*/

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserList(){
			return (List<User>) hibernateTemplate.find("from User"); 
		} 

	@Override
	public boolean saveUser(User user) {
		int id = (Integer) hibernateTemplate.save(user);
		if (id > 0)
			return true;
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		hibernateTemplate.delete(user);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUserDetailsByEmailAndPassword(String email, String password) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
		detachedCriteria.add(Restrictions.eq("email", email));
		detachedCriteria.add(Restrictions.eq("password", password));
		List<User> findByCriteria = (List<User>) hibernateTemplate.findByCriteria(detachedCriteria);
		if (findByCriteria != null && findByCriteria.size() > 0)
			return findByCriteria.get(0);
		else
			return null;
	}
	
	@Override
	@Transactional(readOnly=false)
	public void updateUserDogSitterStatus(User user) {
		
		logger.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" + user);
		hibernateTemplate.update(user);
		SessionFactory session = hibernateTemplate.getSessionFactory();
		logger.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" + session);
		//entityManager.persist(user);
	
		

		
		
		
	}

	@Override
	public List<User> getDogSitterList() {
		return (List<User>) hibernateTemplate.find("from User where dog_sitter = 1"); 
	}
	


}
