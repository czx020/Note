
/*
���ܼ�飺����DefaultMutableTreeNode��������
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;

public class DefaultMutableTreeNodeTree{
	public DefaultMutableTreeNodeTree(){
		JFrame app=new JFrame("����DefaultMutableTreeNode������");
		Container c=app.getContentPane();    
		DefaultMutableTreeNode root=new DefaultMutableTreeNode("��Դ������"); 
		DefaultMutableTreeNode node1=new DefaultMutableTreeNode("�ҵĹ��İ�");
		DefaultMutableTreeNode node2=new DefaultMutableTreeNode("�ҵĵ���");
		DefaultMutableTreeNode node3=new DefaultMutableTreeNode("�ղؼ�");
		root.add(node1);
		root.add(node2);
		root.add(node3);
   
		DefaultMutableTreeNode leafnode=new DefaultMutableTreeNode("��˾�ļ�");
		node1.add(leafnode);
		leafnode=new DefaultMutableTreeNode("˽���ļ�");
		node1.add(leafnode);
		leafnode=new DefaultMutableTreeNode("�����ż�");
    		node1.add(leafnode);
		leafnode=new DefaultMutableTreeNode("��������(C:)");
		node2.add(leafnode);
		leafnode=new DefaultMutableTreeNode("��������(D:)");
		node2.add(leafnode);
		leafnode=new DefaultMutableTreeNode("��������(E:)");
		node2.add(leafnode);
    
		DefaultMutableTreeNode node31=new DefaultMutableTreeNode("��վ�б�");
		node3.add(node31);
    
		leafnode=new DefaultMutableTreeNode("��������");
		node31.add(leafnode);
		leafnode=new DefaultMutableTreeNode("��������");
		node31.add(leafnode);
		leafnode=new DefaultMutableTreeNode("�������");
		node31.add(leafnode);
    
		JTree tree=new JTree(root);
		JScrollPane scrollPane=new JScrollPane();
		scrollPane.setViewportView(tree);
    
		c.add(scrollPane);
		app.pack();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
  	} 
	public static void main(String[] args){
		new DefaultMutableTreeNodeTree();
  	}  
}
