import java.util.Scanner;
import java.util.Stack;

public class Problem4 {

	public static void main(String[] args) {
		int value, R;
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入十进制数");
		value = scanner.nextInt();
		System.out.println("请输入R");
		R = scanner.nextInt();
		scanner.close();
		
		if(R < 1 || R > 36) { //0-9加26个字母，一共36个符号
			System.out.println("R值无效");
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		while(value >= R) {
			stack.push(value % R);
			value /= R;
		}
		stack.push(value);
		System.out.println("结果");	
		while (!stack.isEmpty()) {
			value = stack.pop();
			if (value <= 9) {
				System.out.print(value);
			} else {
				System.out.println((char)('A' + (value - 10)));
			}
		}
	}

}