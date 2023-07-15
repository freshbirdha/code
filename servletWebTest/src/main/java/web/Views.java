package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Views
 */
@WebServlet("/Views")
public class Views extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Views() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		/**
		 * 1.获取ServletContext对象
		 * 2.从ServletContext对象中获取名为count的属性
		 * 3.如果存在，给访问量加1，然后保存回去
		 * 4.如果不存在，说明第一次访问，向Servletcontext中保存名为count的属性，值为1
		 */
		ServletContext appContext = this.getServletContext();
		Integer count =(Integer)appContext.getAttribute("count");
		if(count==null) {
			appContext.setAttribute("count", 1);
			
		}else {
			appContext.setAttribute("count", count+1);
		}
		
		/**
		 * 向浏览器输出
		 * 需要使用响应对象
		 * 
		 */
		
		PrintWriter pWriter = response.getWriter();
		
		pWriter.print("<h1>" + count + "</h1>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
