package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/BServlet")
public class BServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String xml = "<students>" +
			"<student number='ITCAST_1001'>" +
			"<name>zhangSan</name>" +
			"<age>18</age>" + 
			"<sex>male</sex>" +
			"</student>" +
			"</students>";
		
		response.setContentType("text/xml;charset=utf-8");
		response.getWriter().print(xml);
	}
}
