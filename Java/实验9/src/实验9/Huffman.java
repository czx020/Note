package 实验9;
import java.util.Scanner;
public class Huffman {
	public static void main(String[]args) {
		Tree tree = new Tree();
		tree.createTree();
		tree.output();
	}
	public static class Tree {
		class Node {
			char value;
			int weight;
			int lc;
			int rc;
			int parent;
		}
		Node[] nodes = new Node[20];
		int n;
		public void createTree() {
			System.out.println("请输入叶子数（小于10)");
			Scanner scanner = new Scanner(System.in);
			this.n = scanner.nextInt();
			for (int i = 0;i<2*n-1;i++){
				nodes[i] = new Node();
				nodes[i].lc = -1;
				nodes[i].rc = -1;
				nodes[i].parent = -1;
			}
			System.out.println("请输入叶子的值");
			for (int i = 0;i < n;i++){
				nodes[i].value = scanner.next().charAt(0);	
			}
			
			System.out.println("请输入叶子的权重");
			for (int i = 0;i<n;i++) {
				nodes[i].weight = scanner.nextInt();
			}
			scanner.close();
			for (int i = n;i<2*n-1;i++){
				int min1 =100,min2 = 100; int index1 = -1, index2 = -1;
				for (int j = 0;j < i;j++){
					if (nodes[j].parent == -1) {
						if (nodes[j].weight < min1){
							min2 = min1;
							index2 = index1;
							min1 = nodes[j].weight;
							index1 = j;
						}else if (nodes[j].weight < min2) {
							min2 =nodes[j].weight;
							index2 = j;
						}	
					}
				}
				if (index1 == -1 || index2 == -1) {
					break;
				}
				nodes[i].weight = nodes[index1].weight + nodes[index2].weight;
				nodes[i].lc = index1;
				nodes[i].rc = index2;
				nodes[i].value =' ';
				nodes[index1].parent = i;
				nodes[index2].parent = i;
				
			}
			
		}
		public void output() {
			int[] temp = new int[this.n];
			for (int i = 0;i < n;i++){
				Node node = nodes[i];
				int num = 0;
				while (node.parent != -1) {
					temp[num++] = (i == nodes[node.parent].lc) ? 0 : 1;
					node = nodes[node.parent];
				}
				System.out.print(nodes[i].value + ":");
				while(num>0) {
					System.out.print(temp[--num]);
				}
				System.out.println();
			}
			
		}
	}
}
