package jaxpsax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TestSax {

	public static void main(String[] args) throws Exception {
		/**
		 * 1.创建解析器工厂
		 * 2.创建解析器
		 * 3.执行parese方法
		 * 
		 * 4.自己创建类，继承DefaultHandler方法并重写类的三个方法start element,characters,endElement
		 *
		 */
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		
		SAXParser saxParser = saxParserFactory.newSAXParser();
		
		//saxParser.parse("src/p1.xml", new Mydefault());
		
		saxParser.parse("src/p1.xml", new Mydefault2());

	}

}
class Mydefault extends DefaultHandler {

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		System.out.print(new String(ch,start,length));
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		System.out.print("<" + qName + ">");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		System.out.print("<" + qName + ">");
	}
	
	
}

class Mydefault2 extends DefaultHandler {
	boolean flag = false;
	//int idx = 1; 定义成员便令
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//判断qName是否是name元素
		if("name".equals(qName)) {
			flag = true;
		}
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		//当flag值是true时候，表示解析到name元素
		
		if(flag == true ) {
			
			//if(flag == true && idx == 1) {//获取第一个name元素
			
			System.out.println(new String(ch,start,length));
		}
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		//把flag设置成false， 表示name元素结束
		if("name".equals(qName)) {
			flag = false;
			//idx++;
			
		}
	
	}


	
	
}