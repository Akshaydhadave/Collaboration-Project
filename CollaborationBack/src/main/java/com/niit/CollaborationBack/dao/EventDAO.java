package com.niit.CollaborationBack.dao;

import java.util.List;

import com.niit.CollaborationBack.dto.Adminevent;

public interface EventDAO {

	Adminevent get(int id);
	List<Adminevent> list();
	boolean add(Adminevent evt);
	boolean update(Adminevent evt);
	boolean delete(Adminevent evt);
	
}
