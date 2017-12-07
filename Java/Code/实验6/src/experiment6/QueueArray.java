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
			System.out.printf("队列已满，无法进队！");
			return false;                         /* 返回进队失败标志 */
		}
		else
		{
			this.elements[this.rear]=data;               /* x进队列 */
			this.rear = (this.rear+1) % capacity;  /* rear指向队尾下一个空位 */
			return true;                              /* 返回进队成功标志 */
		}
	}

	public boolean dequeue() {
		if (this.isEmpty()) {
			System.out.printf("队列是空的，无法出队！");
			return false;      /* 返回出队失败标志 */
		} else {
			this.front = (this.front + 1) % capacity;
			return true;
		}
	}

	public T getFront() {
		if (this.rear == this.front) {
			System.out.printf("队列是空的，无法取队头！");
		}
		return (T)this.elements[this.front];
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int boynum;int girlnum;int k;int girl = 0;int boy = 0;
		 System.out.println("请输入男孩个数");
		 boynum = input.nextInt();
		 System.out.println("请输入女孩个数");
		 girlnum = input.nextInt();
		 // 初始化，假设队列存放男女生编号，从1开始
		 QueueArray<Integer> boyqueue = new QueueArray<Integer>(boynum);
		 for (int i = 1; i <= boynum; i++) {
		  boyqueue.enqueue(i);
		 }
		 QueueArray<Integer> girlqueue = new QueueArray<Integer>(girlnum);
		 for (int i = 1; i <= girlnum; i++) {
		  girlqueue.enqueue(i);
		 }
		 System.out.println("请输入曲目数");
		 k = input.nextInt();
		 for (int i = 1; i <=k; i++) {
			   // 跳舞，第一个问题：输出每曲配对情况
			   // 跳过的排到对尾
			   boy = (Integer) boyqueue.getFront();
			   girl =  (Integer) girlqueue.getFront();
			   boyqueue.dequeue();
			   girlqueue.dequeue();
			   boyqueue.enqueue(boy);
			   girlqueue.enqueue(girl);
		  }
			  System.out.println("***第" + k + "首舞曲是:第"+boy+"个男孩与第"+girl+"女孩跳舞！");
			  }
	
}
