import java.util.LinkedList;
import java.util.Queue;

import java.util.Scanner;
public class Dance 
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int x;int y;int k;int girl = 0;int boy = 0;
		 System.out.println("请输入男孩个数");
		 x = input.nextInt();
		 System.out.println("请输入女孩个数");
		 y = input.nextInt();
		 // 初始化，假设队列存放男女生编号，从1开始
		 Queue<Integer> boys = new LinkedList<Integer>();
		 for (int i = 1; i <= x; i++) {
		  boys.add(i);
		 }
		 Queue<Integer> girls = new LinkedList<Integer>();
		 for (int i = 1; i <= y; i++) {
		  girls.add(i);
		 }
		 System.out.println("请输入曲目数");
		 k = input.nextInt();
			  for (int i = 1; i <=k; i++) {
			   // 跳舞，第一个问题：输出每曲配对情况
			   // 跳过的排到对尾
			   boy = (Integer) boys.remove();
			   boys.add(boy);
			   girl = (Integer) girls.remove();
			   girls.add(girl);
			   }
			  System.out.println("***This is the " + k + "st dance:");
			  System.out.println("第"+boy+"个男孩与第"+girl+"女孩跳舞");
			  }
		 
	}