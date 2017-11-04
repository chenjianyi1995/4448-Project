package com.roverandfriends.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.roverandfriends.dao.UserDAO;
import com.roverandfriends.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	

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

}
