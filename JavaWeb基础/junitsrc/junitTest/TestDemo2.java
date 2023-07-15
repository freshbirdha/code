package junitTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;
/**
 * 很重要!!!!!!
 * 泛型里面写的是一个对象，例如String，不能写基本的数据类型
 * 应该写基本数据类型对象的包装类，如int对应Integer, char对应Character,
 * byte对应Byte....(其它对应首字母大写)
 * @author USER
 *
 */
public class TestDemo2 {
	
	//泛型在set上的使用
		@Test
		public void testMap() {
			Map<String, String> map = new HashMap<String,String>(); 
			map.put("aaa", "111");
			map.put("bbb", "222");
			map.put("ccc", "333");
			
			
			//遍历方法1 :获取所有的key，通过key得到value,使用get方法
			
			Set<String> sets = map.keySet();
			
			for (String key : sets) {
				//通过key得到value
				String value = map.get(key);
				System.out.println(key + " : " + value);
			}
			
			System.out.println("----------");
			
			//2. 得到key和value的关系
			Set<Entry<String, String>> setsEs =map.entrySet();
			for (Entry<String, String> entry : setsEs) {
				//entry是key和value关系
				String keyv =entry.getKey();
				String valuev =entry.getValue();
				System.out.println(keyv + "  : " + valuev);
			}
		}
	
	
	//泛型在set上的使用
		@Test
		public void testSet() {
			Set<String> set = new HashSet<String>();
			set.add("www");
			set.add("xxx");
			set.add("yyy");
			
			
			//增强for遍历
			for (String string : set) {
				System.out.println(string);
			}
			System.out.println("---------");
			//使用迭代器
			Iterator<String> iterator = set.iterator();
			while (iterator.hasNext()) {
				String string = (String) iterator.next();
				System.out.println(string);
				
			}
		}
	
	//泛型在list上的使用
	@Test
	public void testList() {
		List <String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		//普通for遍历
		for(int i=0;i<list.size();i++) {
			String string = list.get(i);
			System.out.println(string);
		}
		
		System.out.println("-------------");
		
		//增强for
		for (String string : list) {
			System.out.println(string);
		}
		
		System.out.println("-------------");
		
		//使用迭代器
		
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	}
}
