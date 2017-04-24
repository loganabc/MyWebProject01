package me.gacl.service.impl;

import me.gacl.dao.IUserDao;
import me.gacl.dao.impl.UserDaoImpl;
import me.gacl.domain.User;
import me.gacl.exception.UserExistException;
import me.gacl.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserDao userDao = new UserDaoImpl();
	
	@Override
	public void registerUser(User user) throws UserExistException{
		if(userDao.find(user.getUserName())!=null){
			throw new UserExistException("注册的用户名已经存在！！！");
		}
		userDao.add(user);
	}
	
	@Override
	public User loginUser(String userName,String userPwd){
		return userDao.find(userName, userPwd);
	}
	

}
