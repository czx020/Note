
/*
 	���ܼ�飺����TreeModel��������
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;

public class TreeModelTree{
	public TreeModelTree(){
		JFrame app=new JFrame("����TreeModel������");
		Container c=app.getContentPane();
          
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("��Դ������");
		DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("�ҵĹ��İ�");
		DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("�ҵĵ���");
		DefaultMutableTreeNode node3 = new DefaultMutableTreeNode("�ղؼ�");
		//DefaultMutableTreeNode node4 = new DefaultMutableTreeNode("Readme");
        
		DefaultTreeModel treeModel = new DefaultTreeModel(root);

		/*ʹ��DefaultTreeModel�����ṩ��insertNodeInto()��������ڵ㵽���ڵ��������ʹ��DefaultMutableTreeNode�����ṩ��getChildCount()����ȡ��Ŀǰ�ӽڵ��������*/
		treeModel.insertNodeInto(node1, root, root.getChildCount());
		treeModel.insertNodeInto(node2, root, root.getChildCount());
		treeModel.insertNodeInto(node3, root, root.getChildCount());
		//treeModel.insertNodeInto(node4, root, root.getChildCount());
        
		DefaultMutableTreeNode leafnode=new DefaultMutableTreeNode("��˾�ļ�");
		//ʹ��DefaultTreeModel�����ṩ��insertNodeInto()��������ڵ㵽���ڵ������.
		treeModel.insertNodeInto(leafnode, node1, node1.getChildCount());
		leafnode = new DefaultMutableTreeNode("�����ż�");
		treeModel.insertNodeInto(leafnode, node1, node1.getChildCount());
		leafnode = new DefaultMutableTreeNode("˽���ļ�");
		treeModel.insertNodeInto(leafnode, node1, node1.getChildCount());
        
		leafnode = new DefaultMutableTreeNode("��������(C:)");
		treeModel.insertNodeInto(leafnode, node2, node2.getChildCount());
		leafnode = new DefaultMutableTreeNode("��������(D:)");
		treeModel.insertNodeInto(leafnode, node2, node2.getChildCount());
		leafnode = new DefaultMutableTreeNode("��������(E:)");
		treeModel.insertNodeInto(leafnode, node2, node2.getChildCount());
        
		DefaultMutableTreeNode node31 = new DefaultMutableTreeNode("��վ�б�");
		treeModel.insertNodeInto(node31, node3, node3.getChildCount());
		leafnode= new DefaultMutableTreeNode("��������");
		treeModel.insertNodeInto(leafnode, node3, node3.getChildCount());
		leafnode= new DefaultMutableTreeNode("��������");
		treeModel.insertNodeInto(leafnode, node3, node3.getChildCount());
		leafnode= new DefaultMutableTreeNode("�������");
		treeModel.insertNodeInto(leafnode, node3, node3.getChildCount());
        
        	//��TreeModel����JTree��
        	JTree tree = new JTree(treeModel);
        	//�ı�JTree�����
          	tree.putClientProperty("JTree.lineStyle","Horizontal");
        	JScrollPane scrollPane = new JScrollPane();
        	scrollPane.setViewportView(tree);
      
       		 c.add(scrollPane);
        	app.pack();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	app.setVisible(true);	
    	}
   	public static void main(String args[]) {   
        	new TreeModelTree();
    	}
}
