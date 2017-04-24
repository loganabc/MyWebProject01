package me.gacl.test;

import java.util.Date;

import me.gacl.dao.impl.UserDaoImpl;
import me.gacl.domain.User;

public class testDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User a = new User();
		a.setBirthday(new Date(1992-01-01));
		a.setEmail("123@qq.com");
		a.setId("111");
		a.setUserName("logan");
		a.setUserPwd("1234");
		UserDaoImpl userDao = new UserDaoImpl();
		userDao.add(a);
		System.out.println("³É¹¦£¡");
	}

}
