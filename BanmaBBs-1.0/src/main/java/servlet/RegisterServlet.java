package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String uName = request.getParameter("uName");
		String uPass = request.getParameter("uPass");
		String uPass1 = request.getParameter("uPass1");
		String gender = request.getParameter("gender");
		
		//System.out.println(gender);
		
		String head = request.getParameter("head");
		
		if(uPass == null || "".equals(uPass)
				|| uPass1 == null ||"".equals(uPass1)
				|| uName == null || "".equals(uName)
				|| gender == null || "".equals(gender)
				|| head == null || "".equals(head)){
			request.setAttribute("message", "参数错误，请输入完整的数据");
			request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
			return;
		}
		
		if(uPass1 == null || !uPass1.equals(uPass)) {
			request.setAttribute("message", "两次密码不相等");
			request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
			return;
		}
		UserDao userDao = new UserDao();
		User user = new User();
		user.setHeadImage(head);
		user.setSex(gender);
		user.setPassword(uPass);
		user.setUsername(uName);
		
		userDao.addUser(user);
		
		if(userDao.addUser(user)) {
			request.getRequestDispatcher("/WEB-INF/view/registerCG.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
		}
		
		//成功以后，例如重定向到login
		response.sendRedirect("login");
	}

}
