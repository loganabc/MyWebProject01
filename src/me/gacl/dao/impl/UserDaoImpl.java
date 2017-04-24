package me.gacl.dao.impl;

import java.text.SimpleDateFormat;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import me.gacl.dao.IUserDao;
import me.gacl.domain.User;
import me.gacl.util.XmlUtils;

public class UserDaoImpl implements IUserDao {

	@Override
	public User find(String userName, String userPwd) {
		// TODO Auto-generated method stub
		try {
			System.out.println(2);
			Document document = XmlUtils.getDocument();
			System.out.println(1);
			Element e = (Element) document.selectSingleNode("//user[@userName='"+userName+"' and @userPwd='"+userPwd+"']");
			if(e==null){
				return null;
			}
			User user = new User();
			user.setId(e.attributeValue("id"));
			user.setEmail(e.attributeValue("email"));
			user.setUserPwd(e.attributeValue("userPwd"));
			user.setUserName(e.attributeValue("userName"));
			//String birth = e.attributeValue("birthday");
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//user.setBirthday(sdf.parse(birth));
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		try{
			System.out.println("ªÒ»°document1");
			Document document = XmlUtils.getDocument();
			Element root = document.getRootElement();
			
			Element user_node = DocumentHelper.createElement("user");
			user_node.addAttribute("id", user.getId());
			user_node.addAttribute("userName", user.getUserName());
			user_node.addAttribute("userPwd", user.getUserPwd());
			user_node.addAttribute("email", user.getEmail());
			System.out.println(user.getEmail());
			root.add(user_node);
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//user_node.addAttribute("birthday", sdf.user.getBirthday());
			
			XmlUtils.write2Xml(document);
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}

	}

	@Override
	public User find(String userName) {
		// TODO Auto-generated method stub
		try {
			Document document = XmlUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//user[@userName='"+userName+"']");
			if(e == null){
				return null;
			}
			User user = new User();
			user.setId(e.attributeValue("id"));
			user.setEmail(e.attributeValue("email"));
			user.setUserName(e.attributeValue("userName"));
			user.setUserPwd(e.attributeValue("userPwd"));
			
			String birth = e.attributeValue("birthday");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			user.setBirthday(sdf.parse(birth));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}


































