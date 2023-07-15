package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BanKuaiDao;
import dao.TieziDao;
import entity.BanKuai;
import entity.TieZi;
import entity.User;

/**
 * Servlet implementation class FatieServlet
 */
public class FatieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FatieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bidstr = request.getParameter("bid");
		if(bidstr == null || "".equals(bidstr)) {
			//给予错误提示
			request.getRequestDispatcher("/WEB-INF/view/listError.jsp").forward(request, response);
			return;
		}
		
		int bid = Integer.valueOf(bidstr);
	
		User user =(User)request.getSession().getAttribute("user");
		if(user == null) {
			//给予错误提示
			request.setAttribute("message", "发帖之前，您需要先登录 <a href=\"login\"> 》》》去登录</a>");
			request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
			return;
		}
		
		
		
		BanKuaiDao banKuaiDao = new BanKuaiDao();
		BanKuai banKuai=banKuaiDao.getBanKuaiById(bid);
		request.setAttribute("bk", banKuai);
	
		request.getRequestDispatcher("/WEB-INF/view/fatie.jsp").forward(request, response);
	
	
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String bidstr = request.getParameter("bid");
		if(bidstr == null || "".equals(bidstr)) {
			//给予错误提示
			request.getRequestDispatcher("/WEB-INF/view/listError.jsp").forward(request, response);
			return;
		}
		
		int bid = Integer.valueOf(bidstr);
		
		String title = request.getParameter("title");
		
		String content = request.getParameter("content");
		User user =(User)request.getSession().getAttribute("user");
		if(title == null || content == null || "".equals(content) || "".equals(title)) {
			
			request.setAttribute("message", "请您填写标题和内容 <a href=\"fatie?bid="+bid+"\"> 》》》去发帖</a>");
			request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
			return;
		}
		//把表单中的数据封装到TIezi对象中
		TieziDao tieziDao = new TieziDao();
		TieZi tieZi = new TieZi();
		
		tieZi.setBid(bid);
		tieZi.setContent(content);
		tieZi.setTitle(title);
		tieZi.setUid(user.getUid());
		
		
		long tid = tieziDao.addTieZi(tieZi);
		
		if(tid > 0) {
			response.sendRedirect("tiezi?tid="+tid);
		}else {
			request.setAttribute("message", "发帖失败,请重新尝试 <a href=\"fatie?bid=\"+bid+\"\"> 》》》去发帖</a>");
			request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
		}
		
	}

}
