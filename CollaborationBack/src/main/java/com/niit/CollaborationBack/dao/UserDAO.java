package com.niit.CollaborationBack.dao;

import java.util.List;

import com.niit.CollaborationBack.dto.Usertable;

public interface UserDAO {

	Usertable get(int id);
	List<Usertable> list();
	boolean add(Usertable user);
	boolean update(Usertable user);
	boolean delete(Usertable user);
	
	public Usertable validateUser(Usertable user);
	public Usertable getUserByEmail(String email);
	public List<Usertable> nalist();
	List<Usertable> approvlist();
	
	boolean updateUserProfile(String fileName, int id);
}
