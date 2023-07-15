package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Aservlet
 */
@WebServlet("/Aservlet")
public class Aservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Aservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		//获取url的相关方法
		
		
		response.getWriter().println(request.getScheme());//获取请求协议
		
		response.getWriter().println(request.getServerName());//获取服务器名称
		
		response.getWriter().println(request.getServerPort());//获取服务器端口号
	
		response.getWriter().println(request.getContextPath());//获取项目名称
	
		response.getWriter().println(request.getServletPath());//获取Servlet路径
	
		response.getWriter().println(request.getQueryString());//获取参数部分

		
		response.getWriter().println(request.getRequestURI());//获取请求URI
		
		
		response.getWriter().println(request.getRequestURL());
		
		
		/**
		 * http
			localhost
			8080
			/servletWebTest
			/Aservlet
			username=111dg&password=1234567
			/servletWebTest/Aservlet
			http://localhost:8080/servletWebTest/Aservlet
		 */
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
