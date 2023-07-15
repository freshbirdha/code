package thread;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
/**
 * 
 * @author USER
 *
 */
public class Demo {
	@Test
	public void fun1() {
	final ThreadLocal<String> t1 = new ThreadLocal<String>();
	//	t1.set("hello");//存		
		
		
		new Thread() {
			public void run() {
				t1.set("内部类存");
//				System.out.println("内部类: " + t1.get());
			}
			
		}.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t1.get());
	}
	
	@Test
	public void fun2() {
		Map<Thread, String>map = new HashMap<Thread,String>();
		map.put(Thread.currentThread(),"hello");
		System.out.println(map.get(Thread.currentThread()));
		
		new Thread() {
			public void run() {
				System.out.println(Thread.currentThread().getName());
				System.out.println(map.get(Thread.currentThread()));
			}
		}.start();
	}
}

class User{
	private ThreadLocal<String> usernameT1 = new ThreadLocal<String>();
}



/**
 * ThreadLoacal内部是map
 * @author USER
 *
 * @param <T>
 */
class TL<T>{
	private Map<Thread, T>map = new HashMap<Thread,T>();
	
	public void set (T data) {
		//使用当前线程做key
		map.put(Thread.currentThread(), data);
	}
	
	public T get() {
		return map.get(Thread.currentThread());
	}
	
	public void remove() {
		map.remove(Thread.currentThread());
		
	}
}
