package shiyan7;
import java.util.Scanner;
import java.util.Stack;
import sun.invoke.util.Wrapper;
public class Inorder{
	public static void main(String[]args){
		Tree tree= new Tree();
		Scanner scanner = new Scanner(System.in);
		tree.createTree(scanner);
		System.out.println("中序编立结果");
		tree.inorderTraversal();	
	}
	public static class Tree{
		class Node{
			int value;
			Node left;
			Node right;
		}
		class Wrapper{
			Node node;
			int flag = 1;
		}
		private Node root = null;
		public void createTree(Scanner scanner) {
			System.out.println("输入绪点位，0表示空绪点");
			root= create(scanner);
		}
		public Node getRoot() {
			return root;
		}
		public Node create(Scanner scanner) {
		int value = scanner.nextInt();
		if (value==0){//value为0表示空绪点
			return null;
		}else{
		  Node node = new Node();
		  node.value = value;
		  node.left = create(scanner);
		  node.right = create(scanner);
		  return node;
		}
	}
public void inorderTraversal(){
	Stack<Wrapper>stack = new Stack<Wrapper>();
	Wrapper wrapper = new Wrapper();
	wrapper.node = root;
	stack.push(wrapper);
	while(!stack.isEmpty()){
		Wrapper w= stack.pop();
		Node node = w.node;
		if(w.flag==2){
			System.out.println(node.value);
			if(node.right !=null){
				wrapper.node=node.right;
				stack.push(wrapper);
			}
			continue ;
		}
if (node.left == null && node.right == null){
		System.out.println(node.value);
	}else if (node.left == null) {
				System.out.println(node.value);
				wrapper = new Wrapper();
				wrapper.node = node.right;
				stack.push(wrapper);
				}else{
			  if(w.flag==2){
				  System.out.println(node.value);
				  if(node.right !=null){
					  wrapper = new Wrapper();
					  wrapper.node = node.right;
					  stack.push(wrapper);
				  }
				  continue;
   				}else{
	   				w.flag=2;
	   				stack.push(w);
	   				wrapper=new Wrapper();
	   				wrapper.node =node.left;
	   				stack.push(wrapper);
     				}
				}
			}
		}
	}
}
