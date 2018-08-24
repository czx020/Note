import java.util.Scanner;
import java.util.Stack;

public class Problem4 {

	public static void main(String[] args) {
		int value, R;
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ʮ������");
		value = scanner.nextInt();
		System.out.println("������R");
		R = scanner.nextInt();
		scanner.close();
		
		if(R < 1 || R > 36) { //0-9��26����ĸ��һ��36������
			System.out.println("Rֵ��Ч");
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		while(value >= R) {
			stack.push(value % R);
			value /= R;
		}
		stack.push(value);
		System.out.println("���");	
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