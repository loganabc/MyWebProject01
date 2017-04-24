package me.gacl.web.frombean;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

/**
 * ��װ���û�ע���bean����������register.jsp�б��������ֵ
 * RegisterFromBean�е�������register.jsp�еı��������nameһһ��Ӧ
 * RegisterFromBean����������������register.jsp�еı��������ֵ֮�⣬
 * ��������У����������ֵ�ĺϷ���
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
	 * У�鲻ͨ���Ǹ��û���ʾ
	 */
	private Map<String,String> errors = new HashMap<String,String>();
	
	public Map<String,String>getErrors(){
		return errors;
	}
	public void setErrors(Map<String,String>errors){
		this.errors = errors;
	}
	
	/**
	 * validate��������У���������
	 * ��������У�����
	 * 	private String userName�û�������Ϊ�գ�����Ҫ��3-8����ĸ��abcdABcd
	 * 	private String userPwd�û����벻��Ϊ�գ�����Ҫ��3-8������
	 * 	private String confirmPwd��������Ҫһ��
	 * 	private String email����Ϊ�գ���Ϊ��Ҫ��һ���Ϸ�������
	 * 	private String birthday����Ϊ�գ���Ϊ��ʱ��Ҫ��һ���Ϸ�������
	 */
	public boolean validate(){
		boolean isOk = true;
		if(this.userName == null||this.userName.trim().equals("")){
			isOk = false;
			errors.put("userName", "�û�������Ϊ��");
		}else{
			if(!this.userName.matches("[a-zA-Z]{3,8}")){
				isOk = false;
				errors.put("userName", "�û���������3-8λ����Ļ����");
			}
		}
		
		if(this.userPwd == null || this.userPwd.trim().equals("")){
			isOk = false;
			errors.put("userPwd", "���벻��Ϊ�գ�");
		}else{
			if(!this.userPwd.matches("\\d{3,8}")){
				isOk = false;
				errors.put("userPwd", "���������3-8λ�����֣���");
			}
		}
		
		//��������Ҫһ��
		if(this.confirmPwd != null){
			if(!this.confirmPwd.equals(this.userPwd)){
				isOk = false;
				errors.put("confirmPwd", "�������벻һ�£���");
			}
		}
		
		if(this.email != null && !this.email.trim().equals("")){
			if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")){
				isOk = false;
				errors.put("email", "���䲻��һ���Ϸ����䣡��");
			}
		}
		
		if(this.birthday != null && !this.birthday.trim().equals("")){
			try{
				DateLocaleConverter conver = new DateLocaleConverter();
				conver.convert(birthday, "yyyy-MM-dd");
			}catch(Exception e){
				isOk = false;
				errors.put("birthday", "���ձ�����һ�����ڣ���");
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





































