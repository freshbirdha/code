package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;

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
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取 提交表单的值
		String uName = request.getParameter("uName");
		String uPass = request.getParameter("uPass");
		
		UserDao userDao = new UserDao();
		User u =userDao.getUserByUserNameAndPw(uName, uPass);
		
		if(u == null) {//用户对象如果为空，就说明账号密码不存在于数据库表中
			//错误提示
			request.setAttribute("message", "账号密码错误");
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			return;
		}
		
		
		//找到对应的信息,做登录操作，在session中放一个值表示已经登录
	
		
		request.getSession().setAttribute("user", u);
		
		//登录成功，重定向到index
		response.sendRedirect("index");
	}

}
