

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Oneservlet
 */
@WebServlet("/Oneservlet")
public class Oneservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Oneservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Onesrvlet...");
		response.setHeader("aaa", "AAA");//设置响应头
	//	response.getWriter().println("hello Oneservlet");//设置向应体,如果请求转发，就没必要设置向应体
		//向request域中添加一个属性
		request.setAttribute("username", "lisi");
		//等同于调用twoservlet的service()方法
		request.getRequestDispatcher("/Twoservlet").forward(request, response);//请求转发
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
