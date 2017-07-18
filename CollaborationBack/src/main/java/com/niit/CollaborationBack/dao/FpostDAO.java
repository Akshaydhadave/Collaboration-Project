package com.niit.CollaborationBack.dao;

import java.util.List;

import com.niit.CollaborationBack.dto.Fpost;

public interface FpostDAO {

	Fpost get(int id);
	List<Fpost> list();
	boolean add(Fpost fpost);
	boolean update(Fpost fpost);
	boolean delete(Fpost fpost);
	
	List<Fpost> fplistByforumid(int forumid);
}
