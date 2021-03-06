package com.niit.CollaborationBack.dao;

import java.util.List;

import com.niit.CollaborationBack.dto.Fmember;

public interface FmemberDAO {

	Fmember get(int id);
	List<Fmember> list();
	boolean add(Fmember fmember);
	boolean update(Fmember fmember);
	boolean delete(Fmember fmember);
	
	List<Fmember> nafmemberlist();
	List<Fmember> appfmemberlist();
	List<Fmember> fmemberMlist(int forumid);
	List<Fmember> myForumlist(int userid);
}
