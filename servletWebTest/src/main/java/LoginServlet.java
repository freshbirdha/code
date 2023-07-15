

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seesionCode = (String)request.getSession().getAttribute("session_draw");
		String paramCode = request.getParameter("drawdemocode");
		if(!paramCode.equalsIgnoreCase(seesionCode)) {
			request.setAttribute("msg", "验证码错误");
			request.getRequestDispatcher("/session2/login.jsp").forward(request, response);
			return;
		}
		
		
		//处理中文问题
		request.setCharacterEncoding("utf-8");
		
		//获取表单数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//2.校验用户名和密码是否正确
		if(!"web".equalsIgnoreCase(username)) {//登录成功
			
			/**
			 * 附加项 把用户名保存到cookie中,发送给客户端浏览器
			 * 当再次打开login.jsp时，login.jsp中会读取request中的cookie,把它显示到用户名文本框中
			 */
			
			Cookie cookie = new Cookie("uname",username);
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);//保存cookie
			
			/**
			 * 3.如果成功
			 * >保存用户信息到session中
			 * >重定向到succ1.jsp
			 */
			
			HttpSession session = request.getSession();
			session.setAttribute("username", username);//向session域中保存用户名
			response.sendRedirect("/servletWebTest/session2/succ1.jsp");
		}else {//登录失败，则保存错误信息到request域中，并转发到login.jsp
			request.setAttribute("msg", "用户名或密码错误");
			RequestDispatcher qDispatcher = request.getRequestDispatcher("/session2/login.jsp");//得到转发器
			qDispatcher.forward(request, response);
			
		}
	}

}
