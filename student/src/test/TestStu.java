package test;

import service.Stuservice;
import vo.Student;

public class TestStu {

	public static void main(String[] args) throws Exception {
		//testAdd();
		//testDel();
		testSelect();

	}
	//测试查询方法
	public static void testSelect() throws Exception {
		Student student =Stuservice.getStu("100");
		System.out.println(student.toString());
	}
	
	//测试删除方法
	public static void testDel() throws Exception {
		Stuservice.delStu("103");
	}
	
	public static void testAdd() throws Exception {
		Student student = new Student();
		student.setId("103");
		student.setName("wangwu");
		student.setAge("30");
		Stuservice.addStu(student);
	}
	
}
