package shiyan7;
import java.util.Scanner;


public class BinaryTree  {
	private BinaryTreeNode<Integer> root;

	
	public BinaryTree() {
		System.out.println("输入结点值，0表示空结点");
		this.root = create();
	}
	
	public BinaryTreeNode<Integer> create() {
		Scanner scanner = new Scanner(System.in);
		int value = scanner.nextInt();
		if (value == 0) { //value为0表示空结点
			return null;
		} else {
			BinaryTreeNode<Integer> node = new BinaryTreeNode(value);
			node.setLeftChild( create());
			node.setRightChild( create());
			return node;
		}
	}
	
	public void nonrecursionInorderTraversal(BinaryTreeNode<T> node) {
		LinkedStack<BinaryTreeNode<T>> stack = new LinkedStack<BinaryTreeNode<T>>();
		BinaryTreeNode<T> currentNode = node;
		
		do {C\
			while (currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.getLeftChild();
			}
			if (!stack.isEmpty()) {
				currentNode = stack.pop();
				System.out.print(currentNode.getData());
				currentNode = currentNode.getRightChild();
			}
		} while (!stack.isEmpty() || currentNode != null);
	}
	
	public static void main(String[] args) {
		BinaryTree BTree = new BinaryTree();
		
		System.out.println("根结点值为" + BTree.root.getData());
		System.out.println("中序遍历结果为：");
		//nonrecursionInorderTraversal(BTree.root);
		
	}
	
}
