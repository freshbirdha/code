package servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/Upload2Servlet")
public class Upload2Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		/*
		 * 上传三步
		 * 1. 得到工厂
		 * 2. 通过工厂创建解析器
		 * 3. 解析request，得到FileItem集合
		 * 4. 遍历FileItem集合，调用其API完成文件的保存
		 */
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		try {
			List<FileItem> fileItemList = sfu.parseRequest(request);
			FileItem fi1 = fileItemList.get(0);
			FileItem fi2 = fileItemList.get(1);
			
			System.out.println("普通表单项演示：" + fi1.getFieldName() + 
					"=" + fi1.getString("UTF-8"));
			System.out.println("文件表单项演示：");
			System.out.println("Content-Type: " + fi2.getContentType());
			System.out.println("size: " + fi2.getSize());
			System.out.println("filename: " + fi2.getName());
			
			// 保存文件
			File destFile = new File("log.jpg");
			fi2.write(destFile);
		} catch (FileUploadException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
