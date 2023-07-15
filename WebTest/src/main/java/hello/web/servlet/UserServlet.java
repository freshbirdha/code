package hello.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hello.domain.User;
import hello.service.UserService;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 在Servlet中依赖Service,然后通过service完成功能，把结果保存到request中
		 * 最后转发到jsp显示
		 */
		
		UserService userService = new UserService();
		User user =userService.find();
		request.setAttribute("user", user);
		request.getRequestDispatcher("/info.jsp").forward(request, response);
	}

}
