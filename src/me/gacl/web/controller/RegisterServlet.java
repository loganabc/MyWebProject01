package me.gacl.web.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import me.gacl.domain.User;
import me.gacl.exception.UserExistException;
import me.gacl.service.IUserService;
import me.gacl.service.impl.UserServiceImpl;
import me.gacl.util.WebUtil;
import me.gacl.web.frombean.RegisterFromBean;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RegisterFromBean formbean = WebUtil.request2Bean(request, RegisterFromBean.class);
		if(formbean.validate() == false){
			request.setAttribute("formbean", formbean);
			request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
			return;
		}
		
		User user = new User();
		try{
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			user.setEmail(formbean.getEmail());
			user.setUserName(formbean.getUserName());
			user.setUserPwd(formbean.getUserPwd());
			user.setBirthday(formbean.getBirthday());
			System.out.println(1);
			//BeanUtils.copyProperties(user, formbean);
			System.out.println(2);
			user.setId(WebUtil.makeId());
			System.out.println(3);
			IUserService service = new UserServiceImpl();
			System.out.println(4);
			service.registerUser(user);
			System.out.println(5);
			String message = String.format("注册成功！！3秒后为您自动跳转到登录页面！！<meta http-equiv='refresh' content='3;url=%s'/>", request.getContextPath()+"/LoginUIServlet");
			request.setAttribute("message", message);
			request.getRequestDispatcher("message.jsp").forward(request, response);
			
		}catch(UserExistException e){
			formbean.getErrors().put("userName", "注册用户已经存在！！");
			request.setAttribute("formbeab", formbean);
			request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
			
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "对不起，注册失败！！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
