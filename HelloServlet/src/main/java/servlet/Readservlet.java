package servlet;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

/**
 * Servlet implementation class Readservlet
 */

/**获取类路径下的资源
 * 
 * 
 */


@WebServlet("/Readservlet")
public class Readservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Readservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//1.得到classLoader类加载器
//		ClassLoader cLoader =this.getClass().getClassLoader(); //相对classes
		//让类加载器去类路径下查找资源
		//InputStream is =cLoader.getResourceAsStream("a.txt");
		
		//InputStream is =c.getResourceAsStream("servlet/a.txt");
		
		Class c = this.getClass();
		
		
		//2.调用其getResourceAsStream(),得到一个InputStream
		
		//InputStream is =c.getResourceAsStream("a.txt");//相对当前.class文件所在目录
		
		//相对classes下
	//	InputStream is =c.getResourceAsStream("/a.txt");
		
		//获取index.jsp
		InputStream is =c.getResourceAsStream("/../../index.jsp");
		
		String contents = IOUtils.toString(is, StandardCharsets.UTF_8);
        System.out.println(contents);
		
//		if(is!=null) {
//			
//			BufferedReader bReader = new BufferedReader(new InputStreamReader(is));
//			
//			StringBuffer sB = new StringBuffer();
//			
//			String line = new String("");
//			
//			
//			while((line = bReader.readLine())!=null) {
//				
//				sB.append(line);
//			}
//			
//			String string =sB.toString();
//			System.out.println(string);
//			
//			
//			
//			
//		}
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
