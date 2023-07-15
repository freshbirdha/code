package dom4jXpath;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;

import untils.Dom4jUntils;

public class TestDom4jXpath {

	public static void main(String[] args) throws Exception {
		// test1();
		test2();
	}

	// 获取第一个p1下面的name的值
	public static void test2() throws Exception {
		// 得到document
		Document document = Dom4jUntils.getDocument(Dom4jUntils.PATH_);

		Node name1 = document.selectSingleNode("//p1[@id1='aaaa']/name");

		String s1 = name1.getText();
		System.out.println(s1);

	}

	public static void test1() throws Exception {

		Document document = Dom4jUntils.getDocument(Dom4jUntils.PATH_);

		// 使用selectNodes(//name)方法得到所有name元素

		List<Node> list = document.selectNodes("//name");

		// 遍历list集合
		for (Node node : list) {// node是每一个name元素

			// 得到name元素里的值
			String string = node.getText();
			System.out.println(string);
		}

	}
}
