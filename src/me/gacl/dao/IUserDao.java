package me.gacl.dao;

import me.gacl.domain.User;

public interface IUserDao {
	
	/**
	 * �����û�������������û�
	 */
	User find(String userName,String userPwd);
	
	void add(User user);
	
	User find(String userName);
		
	

}
