package experiment6;
import java.util.Scanner;
public class QueueArray<T> {
	private int capacity;
	private Object[] elements;
	private int front;
	private int rear;

	public QueueArray(int capacity){
		this.capacity = capacity+1;
		this.elements = new Object[this.capacity];
		this.front = 0;
		this.rear = 0;
	}

	public boolean isEmpty() {
		return this.rear == this.front;
	}

	public boolean isFull() {
		return ((this.rear+1)%this.capacity)==this.front;
	}

	public boolean enqueue(T data) {
		if (this.isFull())
		{
			System.out.printf("�����������޷����ӣ�");
			return false;                         /* ���ؽ���ʧ�ܱ�־ */
		}
		else
		{
			this.elements[this.rear]=data;               /* x������ */
			this.rear = (this.rear+1) % capacity;  /* rearָ���β��һ����λ */
			return true;                              /* ���ؽ��ӳɹ���־ */
		}
	}

	public boolean dequeue() {
		if (this.isEmpty()) {
			System.out.printf("�����ǿյģ��޷����ӣ�");
			return false;      /* ���س���ʧ�ܱ�־ */
		} else {
			this.front = (this.front + 1) % capacity;
			return true;
		}
	}

	public T getFront() {
		if (this.rear == this.front) {
			System.out.printf("�����ǿյģ��޷�ȡ��ͷ��");
		}
		return (T)this.elements[this.front];
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int boynum;int girlnum;int k;int girl = 0;int boy = 0;
		 System.out.println("�������к�����");
		 boynum = input.nextInt();
		 System.out.println("������Ů������");
		 girlnum = input.nextInt();
		 // ��ʼ����������д����Ů����ţ���1��ʼ
		 QueueArray<Integer> boyqueue = new QueueArray<Integer>(boynum);
		 for (int i = 1; i <= boynum; i++) {
		  boyqueue.enqueue(i);
		 }
		 QueueArray<Integer> girlqueue = new QueueArray<Integer>(girlnum);
		 for (int i = 1; i <= girlnum; i++) {
		  girlqueue.enqueue(i);
		 }
		 System.out.println("��������Ŀ��");
		 k = input.nextInt();
		 for (int i = 1; i <=k; i++) {
			   // ���裬��һ�����⣺���ÿ��������
			   // �������ŵ���β
			   boy = (Integer) boyqueue.getFront();
			   girl =  (Integer) girlqueue.getFront();
			   boyqueue.dequeue();
			   girlqueue.dequeue();
			   boyqueue.enqueue(boy);
			   girlqueue.enqueue(girl);
		  }
			  System.out.println("***��" + k + "��������:��"+boy+"���к����"+girl+"Ů�����裡");
			  }
	
}
