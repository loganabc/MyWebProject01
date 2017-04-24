package me.gacl.dao;

import me.gacl.domain.User;

public interface IUserDao {
	
	/**
	 * 根据用户名和密码查找用户
	 */
	User find(String userName,String userPwd);
	
	void add(User user);
	
	User find(String userName);
		
	

}
