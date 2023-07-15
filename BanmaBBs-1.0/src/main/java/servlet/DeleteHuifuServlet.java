package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.HuifuDao;
import entity.HuiFu;
import entity.User;

/**
 * Servlet implementation class DeleteHuifuServlet
 */
public class DeleteHuifuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String hidstr = request.getParameter("hid");
		
		if(hidstr == null || "".equals(hidstr)) {
			//给予错误提示
			request.setAttribute("message", "没有对应的回复内容 <a href=\"index\"> 》》》去首页</a>");
			request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
			return;
		}
		
		int hid = Integer.valueOf(hidstr);
		
		String tidstr = request.getParameter("tid");
		if(tidstr == null || "".equals(tidstr)) {
			//给予错误提示
			request.setAttribute("message", "没有找到您想要的帖子信息 <a href=\"index\"> 》》》去首页</a>");
			request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
			return;
		}
		
		int tid = Integer.valueOf(tidstr);
		
		HuifuDao huifuDao = new HuifuDao();
		HuiFu huifu = huifuDao.getHuiFuByHid(hid);
		
		if(huifu == null) {
			//给予错误提示
			request.setAttribute("message", "您没有修改权限 <a href=\"tiezi?tid="+tid+"\"> 》》》去帖子详情页</a>");
			request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
			return;
		}
	
		//保证帖子id是正确的，即数据库的id
		tid=huifu.getTid();
		
		User loginUser = (User) request.getSession().getAttribute("user");
		
		if(loginUser == null) {
			//给予错误提示
			request.setAttribute("message", "请先登录 <a href=\"login\"> 》》》去登录</a>");
			request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
			return;
		}
		
		//判断发帖人ID是否跟当前登录用户一样，如果一样，给予错误提示，不让删除
		if(huifu.getUid() != loginUser.getUid()) {
			//给予错误提示
			request.setAttribute("message", "您没有删除权限 <a href=\"tiezi?tid="+tid+"\"> 》》》去帖子详情页</a>");
			request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
			return;
		}
		
		
		if(huifuDao.delete(hid)) {
			//删除以后，让浏览器重定向到该帖子原来所属的帖子帖子页中
			response.sendRedirect("tiezi?tid="+tid);
		}else {
			request.setAttribute("message", "删除失败，请重新尝试 <a href=\"tiezi?tid="+tid+"\"> 》》》去帖子详情页</a>");
			request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
		}
			
		
	}


}
