package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestDemo1 {

	public static void main(String[] args) throws Exception {
		//获取Class类
		Class c1 = Person.class;
		Class c2 = new Person().getClass();
		Class c3 = Class.forName("reflection.Person");
	}
	
	
	//操作普通方法,比如setName
	@Test
	public void test3()throws Exception{
		//得到Class
		Class c3 = Class.forName("reflection.Person");
		//得到Person实例
		Person p3 = (Person) c3.newInstance();
		//得到普通方法,
		Method m1 =c3.getDeclaredMethod("setNameString", String.class);
		
		m1.invoke(p3, "wangwu");
		
		System.out.println(p3.getNameString());
		
	}
	
	//操作有参构造方法
		@Test
		public void test2()throws Exception{
			//得到Class
			Class c1 = Class.forName("reflection.Person");
			
			Constructor cs =c1.getConstructor(String.class,String.class);
			
			Person p1 = (Person) cs.newInstance("zhangsan","100");
			System.out.println(p1.getNameString() + " " + p1.getIdString());
			
			
		}
		
		
	//操作无参构造方法
	@Test
	public void test1()throws Exception{
		//得到Class
		Class c3 = Class.forName("reflection.Person");
		//得到Person类的实例
		Person person = (Person) c3.newInstance();
		//设置值
		person.setNameString("lisi");
		System.out.println(person.getNameString());
	}
	


}
