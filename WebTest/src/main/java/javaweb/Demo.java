package javaweb;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import commons.CommonUtils;

public class Demo {
	@Test
	public void fun1() throws Exception {
		String className = "javaweb.Person";
		Class  clazz = Class.forName(className);
		Object bean = clazz.newInstance();
		
		BeanUtils.setProperty(bean, "name", "张三");
		BeanUtils.setProperty(bean, "age", "20");
		BeanUtils.setProperty(bean, "gender", "男");
		
		String ageString =BeanUtils.getProperty(bean, "age");
		System.out.println(ageString);
		System.out.println(bean);
	}
	
	
	/**
	 * 把Map中的属性直接封装到一个bean中,要求map的key与bean的属性名相同
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@Test
	public void fun2() throws Exception {
		Map<String, String>map = new HashMap<String,String>();
		map.put("username", "lisi");
		map.put("password", "456");
		
		User user = new User();
		BeanUtils.populate(user, map);
		System.out.println(user);
		
	}
	
	@Test
	public void fun3() throws Exception {
		Map<String, String>map = new HashMap<String,String>();
		map.put("username", "lisi");
		map.put("password", "456");
		
		User user = CommonUtils.toBean(map, User.class);
		System.out.println(user);
		
	}
}
