package shiyan9;
import java.util.Scanner;
public class CreatGraph{
	public static void main(String[]args) {
		Graph graph = new Graph();
		graph.createGraph();
		graph.output();
	}
	public static class Graph {
		class eNode {
			int adjvex;
			eNode next;
		}
		class vNode {
			int vertex;
			eNode fadj;
		}
		
		private vNode[] Gv = new vNode[50];
		private int n;
		private int e;
		public void createGraph(){
			System.out.println(" ‰»În(n<50");
			Scanner scanner = new Scanner(System.in);
			this.n = scanner.nextInt();
			for (int i = 1;i<= this.n;i++){
				Gv[i] = new vNode();
				Gv[i].vertex = i;
			}
			System.out.println("«Î ‰»Î±ﬂ");
			int v1 = scanner.nextInt();
			int v2 = scanner.nextInt();
			this.e = 0;
			while(v1 != 0 && v2 !=0){
				eNode node = new eNode();
				node.adjvex = v2;
				node.next = Gv[v1].fadj;
				Gv[v1].fadj = node;
				this.e++;
				v1 = scanner.nextInt();
				v2 = scanner.nextInt();
			}
			scanner.close();
		}
		public void output() {
			for (int i = 1;i <=this.n;i++) {
				System.out.print(Gv[i].vertex + " :");
				eNode node = Gv[i].fadj;
				while (node != null){
					System.out.print("->"+node.adjvex);
					node = node.next;
				}
				System.out.println("");
			}
		}
	}
}