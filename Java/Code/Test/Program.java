
/*
 "实战——九九乘法口诀表"
 */

public class Program {
	public static void main(String [] args) {
		System.out.println("九九乘法口诀表：");
		for (int i=1;i<=9;i++){
			for(int j=1;j<=i;j++){
				System.out.print(j+"*"+i+"="+j*i+"\t");
			}
//			注意print与println的区别
			System.out.print("\n");
//			System.out.println();
		}
	}
}
