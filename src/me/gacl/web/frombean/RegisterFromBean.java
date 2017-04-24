package me.gacl.web.frombean;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

/**
 * 封装的用户注册表单bean，用来接收register.jsp中表单输入项的值
 * RegisterFromBean中的属性与register.jsp中的表单输入项的name一一对应
 * RegisterFromBean的自责出来负责接收register.jsp中的表单输入项的值之外，
 * 还担任着校验表单输入项的值的合法性
 * @author CHENLOU042
 *
 */
public class RegisterFromBean {
	private String userName;
	
	private String userPwd;
	
	private String confirmPwd;
	
	private String email;
	
	private String birthday;
	
	/**
	 * 校验不通过是给用户提示
	 */
	private Map<String,String> errors = new HashMap<String,String>();
	
	public Map<String,String>getErrors(){
		return errors;
	}
	public void setErrors(Map<String,String>errors){
		this.errors = errors;
	}
	
	/**
	 * validate方法负责校验表单输入项
	 * 表单输入项校验规则
	 * 	private String userName用户名不能为空，并且要是3-8的字母，abcdABcd
	 * 	private String userPwd用户密码不能为空，并且要是3-8的数字
	 * 	private String confirmPwd两次密码要一致
	 * 	private String email可以为空，不为空要是一个合法的邮箱
	 * 	private String birthday可以为空，不为空时，要是一个合法的日期
	 */
	public boolean validate(){
		boolean isOk = true;
		if(this.userName == null||this.userName.trim().equals("")){
			isOk = false;
			errors.put("userName", "用户名不能为空");
		}else{
			if(!this.userName.matches("[a-zA-Z]{3,8}")){
				isOk = false;
				errors.put("userName", "用户名必须是3-8位的字幕！！");
			}
		}
		
		if(this.userPwd == null || this.userPwd.trim().equals("")){
			isOk = false;
			errors.put("userPwd", "密码不能为空！");
		}else{
			if(!this.userPwd.matches("\\d{3,8}")){
				isOk = false;
				errors.put("userPwd", "密码必须是3-8位的数字！！");
			}
		}
		
		//两次密码要一致
		if(this.confirmPwd != null){
			if(!this.confirmPwd.equals(this.userPwd)){
				isOk = false;
				errors.put("confirmPwd", "两次密码不一致！！");
			}
		}
		
		if(this.email != null && !this.email.trim().equals("")){
			if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")){
				isOk = false;
				errors.put("email", "邮箱不是一个合法邮箱！！");
			}
		}
		
		if(this.birthday != null && !this.birthday.trim().equals("")){
			try{
				DateLocaleConverter conver = new DateLocaleConverter();
				conver.convert(birthday, "yyyy-MM-dd");
			}catch(Exception e){
				isOk = false;
				errors.put("birthday", "生日必须是一个日期！！");
			}
		}
		return isOk;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getConfirmPwd() {
		return confirmPwd;
	}
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		DateLocaleConverter conver = new DateLocaleConverter();
		return (Date)conver.convert(birthday, "yyyy-MM-dd");
		
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	

}





































