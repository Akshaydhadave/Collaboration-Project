package com.niit.CollaborationBack.dao;

import java.util.List;

import com.niit.CollaborationBack.dto.Job;

public interface JobDAO {

	Job get(int id);
	List<Job> list();
	boolean add(Job job);
	boolean update(Job job);
	boolean delete(Job job);
	
}
