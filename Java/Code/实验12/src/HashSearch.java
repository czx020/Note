import java.util.Scanner;
public class HashSearch {
	public static void main(String[] args) {
		int[] array = new int[15];
		System.out.println("������10����������");
		Scanner scanner = new Scanner(System.in);
		for(int i = 0; i<10;i++);
		int v = scanner.nextInt();
		int pos = v % 11;
		if(array[pos] == 0) {
				array[pos] = v;
			}else {
				int j = 1;
				for(; j <= 3;j++) {
					if (array[pos+j] == 0) {
						array[pos+j] = v;
						break;
					}
				}
				if(j > 3) {
					System.out.println("���ܲ���" + v);
				}
			}
		}
		System.out.println("������Ҫ���ҵ���");
		int target = scanner.nextInt();
		int pos = target % 11;
		int i = 0;
		for (;i<4;i++) {
			if (array[pos+i] == target) {
				System.out.println("�ҵ��������±�Ϊ" + (pos + i));
				break;
			}
		}
		if(i == 4) {
			System.out.println("�Ҳ�������");
		}
		scanner.close();
	}
}
