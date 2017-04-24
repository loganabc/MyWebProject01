package me.gacl.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.gacl.domain.User;
import me.gacl.service.IUserService;
import me.gacl.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		IUserService service = new UserServiceImpl();
		
		User user = service.loginUser(username, password);
		
		if(user == null){
			String message=String.format(
					"�Բ����û��������������󣡣������µ�¼��2���Ϊ���Զ���ת<meta http-equiv='refresh' content='2;url=%s'>",
					request.getContextPath()+"/LoginUIServlet");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		request.getSession().setAttribute("user", user);
		String message = String.format(
				"��ϲ��%s,��¼�ɹ�����ҳ����3�����ת����ҳ����<meta http-equiv='refresh' content='3;url=%s'", user.getUserName(),request.getContextPath()+"/index.jsp");
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

























