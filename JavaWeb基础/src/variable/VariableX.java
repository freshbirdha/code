package variable;
/**
 * 1.可变参数需要写在方法的参数列表中，不能单独定义
 * 2.在方法的参数列表中只能有一个可变参数
 * 3.方法的参数列表中的可变参数，必须放在参数的最后
 * @author USER
 *
 */
public class VariableX {

	public static void main(String[] args) {
		add1(123,12,11);
		add1(11,1);

	}
	public static void add1(int...nums) {
					// add1(int...nums,int a)不能这样写，可变参数必须在最后
		//nums理解为一个数组，这个数组存储传递过来的参数
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum+=nums[i];
		}
		System.out.println(sum);
	}
}
