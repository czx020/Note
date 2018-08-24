
/*
 	功能简介：利用TreeModel建立树。
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;

public class TreeModelTree{
	public TreeModelTree(){
		JFrame app=new JFrame("利用TreeModel建立树");
		Container c=app.getContentPane();
          
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("资源管理器");
		DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("我的公文包");
		DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("我的电脑");
		DefaultMutableTreeNode node3 = new DefaultMutableTreeNode("收藏夹");
		//DefaultMutableTreeNode node4 = new DefaultMutableTreeNode("Readme");
        
		DefaultTreeModel treeModel = new DefaultTreeModel(root);

		/*使用DefaultTreeModel类所提供的insertNodeInto()方法加入节点到父节点的数量；使用DefaultMutableTreeNode类所提供的getChildCount()方法取得目前子节点的数量。*/
		treeModel.insertNodeInto(node1, root, root.getChildCount());
		treeModel.insertNodeInto(node2, root, root.getChildCount());
		treeModel.insertNodeInto(node3, root, root.getChildCount());
		//treeModel.insertNodeInto(node4, root, root.getChildCount());
        
		DefaultMutableTreeNode leafnode=new DefaultMutableTreeNode("公司文件");
		//使用DefaultTreeModel类所提供的insertNodeInto()方法加入节点到父节点的数量.
		treeModel.insertNodeInto(leafnode, node1, node1.getChildCount());
		leafnode = new DefaultMutableTreeNode("个人信件");
		treeModel.insertNodeInto(leafnode, node1, node1.getChildCount());
		leafnode = new DefaultMutableTreeNode("私人文件");
		treeModel.insertNodeInto(leafnode, node1, node1.getChildCount());
        
		leafnode = new DefaultMutableTreeNode("本机磁盘(C:)");
		treeModel.insertNodeInto(leafnode, node2, node2.getChildCount());
		leafnode = new DefaultMutableTreeNode("本机磁盘(D:)");
		treeModel.insertNodeInto(leafnode, node2, node2.getChildCount());
		leafnode = new DefaultMutableTreeNode("本机磁盘(E:)");
		treeModel.insertNodeInto(leafnode, node2, node2.getChildCount());
        
		DefaultMutableTreeNode node31 = new DefaultMutableTreeNode("网站列表");
		treeModel.insertNodeInto(node31, node3, node3.getChildCount());
		leafnode= new DefaultMutableTreeNode("网上聊天");
		treeModel.insertNodeInto(leafnode, node3, node3.getChildCount());
		leafnode= new DefaultMutableTreeNode("网络新闻");
		treeModel.insertNodeInto(leafnode, node3, node3.getChildCount());
		leafnode= new DefaultMutableTreeNode("网络书店");
		treeModel.insertNodeInto(leafnode, node3, node3.getChildCount());
        
        	//以TreeModel建立JTree。
        	JTree tree = new JTree(treeModel);
        	//改变JTree的外观
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
