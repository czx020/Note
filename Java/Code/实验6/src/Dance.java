import java.util.LinkedList;
import java.util.Queue;

import java.util.Scanner;
public class Dance 
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int x;int y;int k;int girl = 0;int boy = 0;
		 System.out.println("�������к�����");
		 x = input.nextInt();
		 System.out.println("������Ů������");
		 y = input.nextInt();
		 // ��ʼ����������д����Ů����ţ���1��ʼ
		 Queue<Integer> boys = new LinkedList<Integer>();
		 for (int i = 1; i <= x; i++) {
		  boys.add(i);
		 }
		 Queue<Integer> girls = new LinkedList<Integer>();
		 for (int i = 1; i <= y; i++) {
		  girls.add(i);
		 }
		 System.out.println("��������Ŀ��");
		 k = input.nextInt();
			  for (int i = 1; i <=k; i++) {
			   // ���裬��һ�����⣺���ÿ��������
			   // �������ŵ���β
			   boy = (Integer) boys.remove();
			   boys.add(boy);
			   girl = (Integer) girls.remove();
			   girls.add(girl);
			   }
			  System.out.println("***This is the " + k + "st dance:");
			  System.out.println("��"+boy+"���к����"+girl+"Ů������");
			  }
		 
	}