package com.spring.dao;    
    
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.spring.beans.Emp;  
 @Repository   
public class EmpDao { 
	@Autowired
	HibernateTemplate template;  
    
	public void setTemplate(HibernateTemplate template) {
		this.template=template;
	}
	@Transactional
	public void save(Emp p) {
		template.save(p);
	}
	@Transactional
	public void update(Emp p) {
		template.update(p);
	}
	@Transactional
	public void delete(Emp p) {
		template.delete(p);
	}

	public Emp getEmpById(int id) {
	Emp p=(Emp)this.template.get(Emp.class, id);
		return p;
	}

		//get all products
		public List<Emp> getEmp()
		{
			List<Emp>list = new ArrayList<Emp>();
			list=template.loadAll(Emp.class);
			return list;
		}
		
}    