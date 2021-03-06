package com.niit.CollaborationBack.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.CollaborationBack.dao.ForumDAO;
import com.niit.CollaborationBack.dto.Forum;

@Repository("forumDAO")
@Transactional
public class ForumDAOImpl implements ForumDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Forum get(int id) {
		return sessionFactory.getCurrentSession().get(Forum.class, Integer.valueOf(id));
	}

	@Override
	public List<Forum> list() {
		String selectActiveForum = "FROM Forum WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveForum);
		
		query.setParameter("active", 'Y');
		
		return query.getResultList();
	}

	@Override
	public boolean add(Forum forum) {
		try {
			
			sessionFactory.getCurrentSession().save(forum);
			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Forum forum) {
		try {
			
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Forum forum) {
		forum.setActive('N');
		 
		try {
	
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Forum> listByUserid(int userid) {
		String selectActiveForum = "FROM Forum WHERE active = :active and user.userid =:userid ";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveForum);
		
		query.setParameter("active", 'Y');
		query.setParameter("userid", userid);
		return query.getResultList();
	}
	
}
