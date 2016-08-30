package com.niit.ShoppingCart.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingCart.model.UserDetails;
@Repository("userDetailsDAO")
public class UserDetailsDAOImpl implements UserDetailsDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDetailsDAOImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
		
	}
@Transactional
  public boolean save(UserDetails userdetails)
{
	try {
		sessionFactory.getCurrentSession().save(userdetails);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	
}
@Transactional
	public boolean update(UserDetails userdetails){
		try {
			sessionFactory.getCurrentSession().update(userdetails);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
@Transactional
	public boolean delete(UserDetails userdetails){
		try {
			sessionFactory.getCurrentSession().delete(userdetails);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
@Transactional
	public UserDetails  get(String id){
		
		String hql =" from UserDetails where id = "+"'"+id+"'";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		List<UserDetails> list = query.list();
		
		if(list == null){
			return null;
	   }else{
		   return list.get(0);
	   }
		
	} 
@Transactional
	public List<UserDetails>  list(){
		
		String hql = "from UserDetails";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
		
	}
	
}
