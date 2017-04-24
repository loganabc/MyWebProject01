package me.gacl.service;

import me.gacl.domain.User;
import me.gacl.exception.UserExistException;

public interface IUserService {
	
	//提供注册服务
	void registerUser(User user)throws UserExistException;
	
	//提供登录服务
	User loginUser(String userName,String userPwd);

}
