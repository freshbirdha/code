package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.BanKuaiDao;
import dao.TieziDao;
import entity.TieZi;
import entity.User;

/**
 * Servlet implementation class UpdateTieziServlet
 */
public class UpdateTieziServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTieziServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tidstr = request.getParameter("tid");
			
		if(tidstr == null || "".equals(tidstr)) {
			//给予错误提示
			request.setAttribute("message", "没有找到您想要的帖子信息 <a href=\"index\"> 》》》去首页</a>");
			request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
			return;
		}
		
		int tid = Integer.valueOf(tidstr);
		
		TieziDao tieziDao = new TieziDao();
		TieZi tieZi = tieziDao.getTiezibyTid(tid);
		if(tieZi == null) {
			//给予错误提示
			request.setAttribute("message", "没有找到您想要的帖子信息 <a href=\"index\"> 》》》去首页</a>");
			request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
			return;
		}
		
		User loginUser = (User) request.getSession().getAttribute("user");
		
		if(loginUser == null) {
			//给予错误提示
			request.setAttribute("message", "请先登录 <a href=\"login\"> 》》》去登录</a>");
			request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
			return;
		}
		
		//判断发帖人ID是否跟当前登录用户一样，如果一样，给予错误提示，不让修改
		if(tieZi.getUid() != loginUser.getUid()) {
			//给予错误提示
			request.setAttribute("message", "您没有修改权限 <a href=\"tiezi?tid="+tieZi.getTid()+"\"> 》》》去帖子详情页</a>");
			request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
			return;
		}
		
		
		
		//获取板块信息
		BanKuaiDao banKuaiDao = new BanKuaiDao();
		request.setAttribute("bk", banKuaiDao.getBanKuaiById(tieZi.getBid()));
		
		request.setAttribute("tiezi", tieZi);
		request.getRequestDispatcher("/WEB-INF/view/updateTiezi.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String tidstr = request.getParameter("tid");
		if(tidstr == null || "".equals(tidstr)) {
			//给予错误提示
			request.getRequestDispatcher("/WEB-INF/view/listError.jsp").forward(request, response);
			return;
		}
		
		int tid = Integer.valueOf(tidstr);
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
		
		if(title == null || content == null || "".equals(content) || "".equals(title)) {
			
			request.setAttribute("message", "请您填写标题和内容 <a href=\"updateTiezi?tid="+tid+"\"> 》》》去修改</a>");
			request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
			return;
		}
		
	
		User loginUser = (User) request.getSession().getAttribute("user");
		if(loginUser == null) {
			//给予错误提示
			request.setAttribute("message", "修改之前请先登录 <a href=\"login\"> 》》》去登录</a>");
			request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
			return;
		}
		
		TieziDao tieziDao = new TieziDao();
		TieZi tieZi = tieziDao.getTiezibyTid(tid);
		
		//判断发帖人ID是否跟当前登录用户一样，如果一样，给予错误提示，不让修改
		if(tieZi.getUid() != loginUser.getUid()) {
			//给予错误提示
			request.setAttribute("message", "您没有修改权限 <a href=\"tiezi?tid="+tieZi.getTid()+"\"> 》》》去帖子详情页</a>");
			request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
			return;
		}
	
		
		//把表单中的数据封装到TIezi对象中
		tieZi.setContent(content);
		tieZi.setTitle(title);
//		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
//		tieZi.setUpdateTime(date);

		//修改数据库
		
		
		if(tieziDao.updateTiezi(tieZi)) {
			response.sendRedirect("tiezi?tid="+tid);
		}else {
			request.setAttribute("message", "修改失败，请重新尝试 <a href=\"tiezi?tid="+tieZi.getTid()+"\"> 》》》去帖子详情页</a>");
			request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
		}
		
	
	}

}
