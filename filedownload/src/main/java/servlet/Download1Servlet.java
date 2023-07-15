package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.Base64.Encoder;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;


@WebServlet("/Download1Servlet")
public class Download1Servlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * 两个头一个流
		 * 1. Content-Type
		 * 2. Content-Disposition
		 * 3. 流：下载文件的数据
		 */
		String filename = "log.jpg";
		
		// 为了使下载框中显示中文文件名称不出乱码！
//		String framename = new String("流光%飞舞.mp3".getBytes("GBK"), "ISO-8859-1");
		String framename = filenameEncoding("log.jpg", req);
		
		String contentType = this.getServletContext()
				.getMimeType(filename);//通过文件名称获取MIME类型
		String contentDisposition = "attachment;filename=" + framename;
		// 一个流
		FileInputStream input = new FileInputStream(filename);
		
		//设置头
		resp.setHeader("Content-Type", contentType);
		resp.setHeader("Content-Disposition", contentDisposition);
		
		// 获取绑定了响应端的流
		ServletOutputStream output = resp.getOutputStream();
		
		IOUtils.copy(input, output);//把输入流中的数据写入到输出流中。
		
		input.close();
	}
	
	// 用来对下载的文件名称进行编码的！
	public static String filenameEncoding(String filename, HttpServletRequest request) throws IOException {
		String agent = request.getHeader("User-Agent"); //获取浏览器
		if (agent.contains("Firefox")) {
			Encoder encoder=Base64.getEncoder();
			filename = "=?utf-8?B?"
					+ encoder.encode(filename.getBytes("utf-8"))
					+ "?=";
		} else if(agent.contains("MSIE")) {
			filename = URLEncoder.encode(filename, "utf-8");
		} else {
			filename = URLEncoder.encode(filename, "utf-8");
		}
		return filename;
	}
}
