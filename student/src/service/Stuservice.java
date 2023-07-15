package service;

import java.io.FileOutputStream;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import vo.Student;



public class Stuservice {
	
	//查询 根据id查询学生信息
	public static Student getStu(String id) throws Exception {
		
		//创建解析器
		SAXReader saxReader = new SAXReader();
		
		//获取document		
		Document document = saxReader.read("src/student.xml");
		
		//获取所有id xpath: //id
		
		List<Node> list = document.selectNodes("//id");
		//创建student对象
		Student student = new Student();
		//遍历list集合
		for (Node node : list) { //node是每一个id元素
			//得到id的值
			String idv = node.getText();
			
			//判断idv和传递的id是否相同
			if(idv.equals(id)) {//id相同
				//得到id的父节点stu
				Element stu =node.getParent();
				
				//通过stu获取name和age
				String nameString = stu.element("name").getText();
				String agevString = stu.element("age").getText();
				student.setId(idv);
				student.setName(nameString);
				student.setAge(agevString);
				
			}
		}
		return student;
		
	}
	
	
	//增加
	public static void addStu(Student student) throws Exception {
		//创建解析器
		SAXReader saxReader = new SAXReader();
		
		//获取document	
		Document document = saxReader.read("src/student.xml");
		
		//得到根节点
		Element root = document.getRootElement();
		
		Element stu= root.addElement("stu");
		
		Element id1 = stu.addElement("id");
		Element name1 = stu.addElement("name");
		Element age1 = stu.addElement("age");
		
		id1.setText(student.getId());
		name1.setText(student.getName());
		age1.setText(student.getAge());
		
		
		//回写
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src/student.xml"),format);
		xmlWriter.write(document);
		xmlWriter.close();
	}
	
	//删除 根据学生的id删除
	public static void delStu(String id) throws Exception {
		//创建解析器
		SAXReader saxReader = new SAXReader();
		
		//获取document		
		Document document = saxReader.read("src/student.xml");
		
		//获取所有id xpath: //id
		
		List<Node> list = document.selectNodes("//id");
		
		//遍历list集合
		for (Node node : list) { //node是每一个id元素
			//得到id的值
			String idv = node.getText();
			
			//判断idv和传递的id是否相同
			if(idv.equals(id)) {//id相同
				//得到stu节点
				Element stu =node.getParent();
				//获取stu的父节点
				Element student = stu.getParent();
				//删除stu
				student.remove(stu);
			}
		}
		
	   //回写
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src/student.xml"),format);
		xmlWriter.write(document);
		xmlWriter.close();
		
	}
	
	

}
