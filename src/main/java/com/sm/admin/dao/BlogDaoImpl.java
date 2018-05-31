package com.sm.admin.dao;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sm.admin.model.Blogs;

@Repository
public class BlogDaoImpl implements BlogDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void saveBlogDetails(Blogs blogs) {
		blogs.setCreated_date(new Date());
		sessionFactory.getCurrentSession().save(blogs);
	}

}
