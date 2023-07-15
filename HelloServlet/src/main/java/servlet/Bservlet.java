package servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/Bservlet")
public class Bservlet implements Servlet {
	
	private ServletConfig config;
	
	
	@Override
	public void destroy() {
	System.out.println("destroy()...");
	
	}
	
	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig()...");
		return this.config;
	}
	
	@Override
	public String getServletInfo() {
		/**
		 * 由TomCat来调用，并且只调用一次
		 * 他是这些方法中国第一个被调用的，他会在构造器之后马上被调用
		 */
		System.out.println("getServletInfo()...");
		return null;
	}
	
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		this.config = config;//把TOMCat传递的Servletconfig赋值给本类的一个成员，其实就是把它保存起来，方便在其他方法中使用
		
		init();//tomcat不会调用自己写的方法，因此可以在子类中进行初始化操作而不会覆盖config
	
	}
	
	//这个方法是本类自己定义的，并不是servlet接口中的方法
	public void init() {
		
	}
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		System.out.println("service()...");
	}
	
	public ServletContext getServletContext() {
		return config.getServletContext();
		
	}
	
	public String getServletName() {
		return config.getServletName();
		
	}
	
	public String getInitParameter(String name) {
		return config.getInitParameter(name);
		
	}
}