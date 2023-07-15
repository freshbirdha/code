package junitTest;


/**
 * 
 * @author USER
 *
 */
public class TestEnum1{
	
//	private int color;
//	private Color2 color1;
	
	private Color3 color3;
	
	public void test() {
		
	//	this.color = Color1.RED;
		
	//	this.color1 = Color2.RED;
		
		this.color3 = Color3.GREEN;
		
		
	}
	
}

//使用枚举实现

enum Color3{
	RED,GREEN,YELLOW;
}


//class Color2{
//	private Color2() {}
//	public static final Color2 RED = new Color2();
//	public static final Color2 Green = new Color2();
//	public static final Color2 Yellow = new Color2();
//}
//
//
//class Color1{
//	
//	public static final int RED = 1;
//	
//	public static final int Green = 2;
//	
//	public static final int Yellow = 3;
//}
