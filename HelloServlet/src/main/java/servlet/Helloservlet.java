package servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Helloservlet
 */
@WebServlet("/Helloservlet")
//public class Helloservlet extends HttpServlet {

//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public Helloservlet() {
//        super();
//     System.out.println("Helloservlet()...");
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 System.out.println("doGet()...");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		System.out.println("doPost()...");
//		doGet(request, response);
//	}

//}
public class Helloservlet implements Servlet {
	@Override
	public void destroy() {
	System.out.println("destroy()...");
	
	}
	
	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig()...");
		return null;
	}
	
	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo()...");
		return null;
	}
	
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println("init()...");
		//获取初始化参数
		System.out.println(servletConfig.getInitParameter("p1"));
		System.out.println(servletConfig.getInitParameter("p2"));
		
		Enumeration<String> elist =servletConfig.getInitParameterNames();
		//获取所有初始化参数的名称
		while (elist.hasMoreElements()) {
			String string = (String) elist.nextElement();
			System.out.println(string);
			
		}
	}
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		System.out.println("service()...");
	}
}