package 实验11;
import java.util.Scanner;
public class Bsearch {
	public static void main(String[]args) {
		System.out.println("请输入一个有序数列");
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		String[] splits = line.split(" ");
		int[] array = new int[splits.length];
		for (int i = 0; i<array.length;i++) {
			array[i] = Integer.parseInt(splits[i]);
		}
		System.out.println("请输入要查找的数");
		int target = scanner.nextInt();
		scanner.close();
		int index = binarySearch(array,target);
		if (index != -1) {
			System.out.println("找到该数下标为" + index);
		}else {
			System.out.println("找不到该数");
		}
	}
	public static int binarySearch(int[] array, int target) {
		int l = 0, r = array.length - 1;
		while (l<r) {
			int m = (l+r)/2;
			if (array[m] == target) {
				return m;
			}else if (array[m] < target) {
				l = m + 1;
			}else {
				r = m - 1;
			}
		}
		return array[l] == target ? l: -1;
	}
}
