package com.niit.ShoppingCart.DAO;

import java.util.List;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Repository;

import com.niit.ShoppingCart.model.Category;



@Repository
public interface CategoryDAO {

	
	
	public boolean update(Category category);
	
	public boolean delete(Category category);
	
	public Category get(String id);
	public List<Category>list();

	public boolean save(Category category);

	

	

}
