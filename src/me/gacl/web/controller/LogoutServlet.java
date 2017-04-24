package me.gacl.web.controller;

import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//开发注销功能
		request.getSession().removeAttribute("user");
		String tempStr1 = MessageFormat.format(
				"注销成功！3秒后为您自动跳转到登录页面！！<meta http-equiv='refresh' content='3;url={0}'/>",
				request.getContextPath()+"/LoginUIServlet");
		System.out.println(tempStr1);
		System.out.println("-------------------------------------------------------------------");
		
		String tempStr2 = MessageFormat.format(
				"注销成功！！3秒后为您自动跳转到登录页面！！<meta http-equiv=''refresh'' content=''3;url={0}''/>", 
				request.getContextPath()+"/LoginUIServlet");
		System.out.println(tempStr2);
		System.out.println("-------------------------------------------------------------------");
		
		String message = String.format(
				"注销成功！！3秒后为您自动跳转到登录页面！！<meta http-equiv='refresh' content='3;url=%s'/>", 
				request.getContextPath()+"/LoginUIServlet");
		request.setAttribute("message", message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
