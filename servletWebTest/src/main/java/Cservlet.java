

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cservlet
 * 演示reuqest获取请求参数
 */
@WebServlet("/Cservlet")
public class Cservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET: " + request.getParameter("xxx"));
		System.out.println("GET: " + request.getParameter("yyy"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String[] hobby = request.getParameterValues("hobby");
		
		
		System.out.println(username + ", " + password + ", " + Arrays.toString(hobby));
		
		//获取所有请求参数的名称
		Enumeration<String> names =request.getParameterNames();
		
		while (names.hasMoreElements()) {
			System.out.println(names.nextElement());
			
		}
		
		
		//获取所有请求参水，封装到Map
		//键Key是参数名，value是值
		Map<String, String[]> map = request.getParameterMap();
		for (String name : map.keySet()) {
			String[] values = map.get(name);
			
			System.out.println(name + "=" + Arrays.toString(values));
		}
	}

}
