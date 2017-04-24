package me.gacl.service;

import me.gacl.domain.User;
import me.gacl.exception.UserExistException;

public interface IUserService {
	
	//�ṩע�����
	void registerUser(User user)throws UserExistException;
	
	//�ṩ��¼����
	User loginUser(String userName,String userPwd);

}
