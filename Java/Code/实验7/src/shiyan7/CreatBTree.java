package shiyan7;
import java.util.Scanner;

public class CreatBTree{
	
	public static void main(String[]args){
		Tree tree = new Tree();
		Scanner scanner = new Scanner(System.in);
		tree.ceateTree(scanner);
		scanner.close();
		System.out.println("根绪点为"+tree.getRoot().value);
	}
	
	public static class Tree{
		class Node{
			int value;
			Node left;
			Node right;
		}
		
		private Node root = null;
		
		public void ceateTree(Scanner scanner){
			System.out.println("请输入绪点数，0表示空绪点");
			root = create(scanner);
		}
		public Node getRoot(){
			return root;
		}
		public Node create(Scanner scanner){
			int value = scanner.nextInt();
			if (value==0){//value为0表示空绪点
				return null;
			}else{
				Node node = new Node();
				node.value = value;
				node.left =create(scanner);
				node.right = create(scanner);
				return node;
			}
		}
	}
}