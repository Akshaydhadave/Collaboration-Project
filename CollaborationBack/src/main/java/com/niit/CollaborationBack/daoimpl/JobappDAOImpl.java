package com.niit.CollaborationBack.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.CollaborationBack.dao.JobappDAO;
import com.niit.CollaborationBack.dto.Jobapp;

@Repository("jobappDAO")
@Transactional
public class JobappDAOImpl implements JobappDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Jobapp get(int id) {
		return sessionFactory.getCurrentSession().get(Jobapp.class, Integer.valueOf(id));
	}

	@Override
	public List<Jobapp> list() {
		String selectActiveJobapp = "FROM Jobapp WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveJobapp);
		
		query.setParameter("active", 'Y');
		
		return query.getResultList();
	}

	@Override
	public boolean add(Jobapp jobapp) {
		try {
			
			sessionFactory.getCurrentSession().save(jobapp);
			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Jobapp jobapp) {
		try {
			
			sessionFactory.getCurrentSession().update(jobapp);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Jobapp jobapp) {
		jobapp.setActive('N');
		 
		try {
	
			sessionFactory.getCurrentSession().update(jobapp);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Jobapp> listByJobid(int jobid) {
		String selectActiveJobappByJobid = "FROM Jobapp WHERE job.jobid = :jobid and active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveJobappByJobid);
		
		query.setParameter("active", 'Y');
		query.setParameter("jobid", jobid);
		
		return query.getResultList();
	}

}
