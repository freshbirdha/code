package dom4j;

import java.io.FileOutputStream;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import untils.Dom4jUntils;

public class TestDom4j {
	public static void main(String[] args) throws Exception {
		
//		selectName();
//		
//		selectSeconName();
//		
//	   	addSex();
//		
//		addAgeBefore();
//		
		modifyAge();
	}
	
	
	//修改第一个p1下age的值
	public static void modifyAge() throws Exception{
		
		Document document = Dom4jUntils.getDocument(Dom4jUntils.PATH_);
		
		//得到根节点
		Element rootElement = document.getRootElement();
		
		//得到第一个p1元素
		Element p1 = rootElement.element("p1");
		
		Element age = p1.element("age");
		
		age.setText("30");
		
//		Dom4jUntils.xmlWriters(Dom4jUntils.PATH_,document);
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(Dom4jUntils.PATH_),format);
		xmlWriter.write(document);
		xmlWriter.close();
		
		
		
	}
	
	//在特定位置添加元素:在第一个p1下面的age之前添加<school>edu.cn</school>
	public static void addAgeBefore() throws Exception{
		//创建解析器
//		SAXReader saxReader = new SAXReader();
//		//得到document
//		Document document = saxReader.read("src/p1.xml");
		
		Document document = Dom4jUntils.getDocument(Dom4jUntils.PATH_);
		
		//得到根节点
		Element rootElement = document.getRootElement();
		
		//得到第一个p1元素
		Element p1 = rootElement.element("p1");
		
		//获取p1下面的所有元素
		
		// 使用list集合里的方法，add(int index, E element)
		
		List<Element> list = p1.elements();
		
		//创建元素，然后添加
		Element schoolElement =DocumentHelper.createElement("school");
		
		//在school下创建文本
		schoolElement.setText("edu");
		
		//在特定位置添加
		list.add(0, schoolElement);
		
		//回写xml
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(Dom4jUntils.PATH_),format);
		xmlWriter.write(document);
		xmlWriter.close();
		
	 // Dom4jUntils.xmlWriters(Dom4jUntils.PATH_,document);
		
		
		
	}
		
	
	//在第一个p1元素末尾添加一个元素<sex>nv</sex>
	public static void addSex() throws Exception{
		//创建解析器
		SAXReader saxReader = new SAXReader();
		//得到document
		Document document = saxReader.read("src/p1.xml");
		//得到根节点
		Element rootElement = document.getRootElement();
		
		//得到第一个p1元素
		Element p1 = rootElement.element("p1");
		
		//在p1下面直接添加元素
		Element sex1 = p1.addElement("sex");
		
		//在sex下添加文本
		sex1.setText("nan");
		
		//回写
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src/p1.xml"),format);
		xmlWriter.write(document);
		xmlWriter.close();
		
		//Dom4jUntils.xmlWriters(Dom4jUntils.PATH_,document);
		
	}
	
	
	//获取第二个name元素的值
	public static void selectSeconName() throws Exception {
		//创建解析器
		SAXReader saxReader = new SAXReader();
		//得到document
		Document document = saxReader.read("src/p1.xml");
		//得到根节点
		Element rootElement = document.getRootElement();
		//得到p1
		List<Element> list =rootElement.elements("p1");
		
		//得到第二个p1
		Element p2  = list.get(1);
		
		//得到p1下面的name		
		Element name2 = p2.element("name");
		
		//得到name里的值
		String s2 = name2.getText();
		
		System.out.println(s2);
		
		
	}
	
	public static void selectName() throws Exception {
		//创建解析器
		SAXReader saxReader = new SAXReader();
		//得到document
		Document document = saxReader.read("src/p1.xml");
		//得到根节点
		Element rootElement = document.getRootElement();
		//得到p1
		List<Element> list =rootElement.elements("p1");
		//遍历list
		for (Element element : list) {
			//element是每个p1元素
			
			//得到name元素
			Element names = element.element("name");
			
			//得到name里的值
			String string = names.getText();
			
			System.out.println(string);
		}
		
		
	}

}
