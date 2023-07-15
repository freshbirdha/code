package junitTest;


import java.util.Arrays;

/**
 * 
 * 实现指定位置上数组元素的交换
 * @author USER
 *
 */
public class TestDemo3 {
	
	public static void main(String[] args) {
		
		//创建一个int数组  实现11和13的位置交换
		//int [] arr1 = {10,11,12,13,14};
		//使用泛型 必须写基本数据类型的包装类
		Integer[] arr1 = {10,11,12,13,14};
		
		System.out.println(Arrays.toString(arr1));
		//首先传入数组，11在数组的第一个位置，13在数组的第三个位置
		swap1(arr1,1,3);
				
		System.out.println(Arrays.toString(arr1));
		
	}
/**
 * 使用泛型方法需要定义一个类型 使用大写字母表示T 这个T表示任意的类型，
 * 字母可以任意，但必须大写
 * 
 */
	public static <T> void swap1(T[] arr,int a,int b) {
		T temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	
	
	
		//	private static void swap1(int[] arr1, int i, int j) {
		//		//定义一个中间变量
		//		int temp = arr1[i];
		//		arr1[i] = arr1[j];
		//		arr1[j] = temp;
		//		
		//		
		//	}
	
	
	
}
