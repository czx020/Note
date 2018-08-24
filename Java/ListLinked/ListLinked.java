
import java.util.Scanner;

public class ListLinked<T extends Comparable<T>> {

    private ListLinkedNode<T> head;

    public  ListLinked() {
        this.head = new ListLinkedNode<T>();
        this.head.setData(null);
        this.head.setNext(null);
    }
       
    public void addFromHead(T nodeData) {
       ListLinkedNode<T> node = new ListLinkedNode<T>();
       node.setData(nodeData);
       node.setNext(this.head.getNext());
       this.head.setNext(node);
   }
    
    public static ListLinked<Integer> createFromHead(){
		ListLinked<Integer> listLinked = new ListLinked<Integer>();
		System.out.println("-头插法建立链表-");
		System.out.println("请输入链表长度：");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println("请输入值：");
		for (int i = 0; i < n; i++) {
			System.out.print("请输入第" + i + "个值:");
			int value = scanner.nextInt();
			listLinked.addFromHead(value);//调用addFromHead()将value插入表头
		}
		System.out.println("链表创建完毕！");
		return listLinked;
	}
   
    public static ListLinked<Integer> createFromTail(){
		ListLinked<Integer> listLinked = new ListLinked<Integer>();
		ListLinkedNode<Integer> tail = listLinked.head;//tail为尾指针

		System.out.println("-尾插法建立链表-");
		System.out.println("请输入链表长度：");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println("请输入值：");
		for (int i = 0; i < n; i++) {
			System.out.print("请输入第" + i + "个值:");
			int value = scanner.nextInt();
			ListLinkedNode<Integer> node = new ListLinkedNode<Integer>();
		    node.setData(value);
		    node.setNext(null);
		    tail.setNext(node);
		    tail = node;
		}
		System.out.println("链表创建完毕！");

		//scanner.close();
		return listLinked;
	}
   
  
    public void display() {
        System.out.print("[");
        ListLinkedNode<T> currentNode = this.head.getNext();
        while (currentNode != null) {
            T value = currentNode.getData();
            System.out.print(value.toString());
            currentNode = currentNode.getNext();
            if(currentNode != null){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public void deleteElement(T e) {
        ListLinkedNode<T> p = this.head.getNext();
        ListLinkedNode<T> q = this.head;
        while (p != null && p.getData().compareTo(e) != 0) {
            q=p;
            p = p.getNext();
        }
        if(p==null)
        	System.out.println("找不到该元素！");
        else
        {
        	q.setNext(p.getNext());
        	System.out.println("删除"+e+"！");
        }
    }

	
    public static void main(String[] args) {
		ListLinked<Integer> listLinked = ListLinked.createFromHead();
		listLinked.display();
		
		//ListLinked<Integer> listLinked2 = ListLinked.createFromTail();
		//listLinked2.display();
		
		System.out.println("请输入要删的元素:：");
		Scanner scanner = new Scanner(System.in);
		int e = scanner.nextInt();
		listLinked.deleteElement(e);
		System.out.println("链表删除"+e+"后：");
		listLinked.display();
		scanner.close();
		return;
    }
}
