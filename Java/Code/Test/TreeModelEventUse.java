
/*
 功能简介：TreeModelEvent事件的使用。
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

public class TreeModelEventUse implements TreeModelListener{
	JLabel label = null;
	String nodeName = null; //原有节点名称	
	public TreeModelEventUse(){
		JFrame app=new JFrame("TreeModelEvent事件的使用");
        	Container c=app.getContentPane();
        	c.setLayout(new BorderLayout());
        	DefaultMutableTreeNode root = new DefaultMutableTreeNode("资源管理器");
        	DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("文件夹");
        	DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("我的电脑");
        	DefaultMutableTreeNode node3 = new DefaultMutableTreeNode("收藏夹");
        	root.add(node1);
        	root.add(node2);
        	root.add(node3);
       
        	DefaultMutableTreeNode leafnode = new DefaultMutableTreeNode("公司文件");
        	node1.add(leafnode);
        	leafnode = new DefaultMutableTreeNode("个人信件");
        	node1.add(leafnode);
        	leafnode = new DefaultMutableTreeNode("私人文件");
        	node1.add(leafnode);
        
        	leafnode = new DefaultMutableTreeNode("本机磁盘(C:)");
        	node2.add(leafnode);
       		leafnode = new DefaultMutableTreeNode("本机磁盘(D:)");
        	node2.add(leafnode);
        	leafnode = new DefaultMutableTreeNode("本机磁盘(E:)");
        	node2.add(leafnode);
        
        	DefaultMutableTreeNode node31 = new DefaultMutableTreeNode("网站列表");
        	node3.add(node31);
        
        	leafnode = new DefaultMutableTreeNode("清华大学出版社");
        	node31.add(leafnode);
        	leafnode = new DefaultMutableTreeNode("郑州轻工业学院");
        	node31.add(leafnode);
        	leafnode = new DefaultMutableTreeNode("网络书店");
        	node31.add(leafnode);
        
        	JTree tree = new JTree(root);
		//设置JTree为可编辑的
        	tree.setEditable(true);
		//使Tree加入检测Mouse事件，以便取得节点名称 
        	tree.addMouseListener(new MouseHandle());
        	//下面两行取得DefaultTreeModel,并检测是否有TreeModelEvent事件.
        	DefaultTreeModel treeModel = (DefaultTreeModel)tree.getModel();
        	treeModel.addTreeModelListener(this);
        
        	JScrollPane scrollPane=new JScrollPane();
        	scrollPane.setViewportView(tree);
        
        	label=new JLabel("更改数据为: ");
        	c.add(scrollPane,BorderLayout.CENTER);
        	c.add(label,BorderLayout.SOUTH);
        	app.pack();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	app.setVisible(true);
    	}
    /*本方法实现TreeModelListener接口，本接口共定义四个方法，分别是TreeNodesChanged()、treeNodesInserted()、treeNodesRemoved()、treeNodesRemoved()、treeStructureChanged()。在此范例中只针对更改节点值的部份，因此只实现treeNodesChanged()方法。*/
	public void treeNodesChanged(TreeModelEvent e){
		TreePath treePath=e.getTreePath();
		System.out.println(treePath);
        /*下面这行由TreeModelEvent取得的DefaultMutableTreeNode为节点的父节点，而不是用户点选的节点，这点读者要特别注意。要取得真正的节点需要再加写下面6行代码。*/
        	DefaultMutableTreeNode node=(DefaultMutableTreeNode)treePath.getLastPathComponent();
        	try {
            	/*getChildIndices()方法会返回目前修改节点的索引值。由于只修改一个节点，因此节点索引值就放在index[0]的位置，若点选的节点为root node,则getChildIndices()的返回值为null，程序下面的第二行就在处理点选root node产生的NullPointerException问题。*/
            		int[] index=e.getChildIndices();
              		//由DefaultMutableTreeNode类的getChildAt()方法取得修改的节点对象
            		node = (DefaultMutableTreeNode)node.getChildAt(index[0]);
        	} catch (NullPointerException exc) {}
        	//由DefaultMutableTreeNode类getUserObject()方法取得节点的内容，或是写成node.toString()亦相同
        	label.setText(nodeName+"更改数据为:"+(String)node.getUserObject());
    	}
    	public void treeNodesInserted(TreeModelEvent e){}
    	public void treeNodesRemoved(TreeModelEvent e){}
    	public void treeStructureChanged(TreeModelEvent e){}

 
    	//处理Mouse点选事件
    	class MouseHandle extends MouseAdapter{
        	public void mousePressed(MouseEvent e){
            	    try{
              		JTree tree = (JTree)e.getSource();
        /*JTree的getRowForLocation()方法会返回节点的列索引值。例如本例中，“本机磁盘(D:)”的列索引值为4，此索引值会随着其他数据夹的打开或收起而变支，但“资源管理器”的列索引值恒为0。*/ 
              	        int rowLocation = tree.getRowForLocation(e.getX(),e.getY());
             	/*JTree的getPathForRow()方法会取得从root node到点选节点的一条path，此path为一条直线，如程序运行的图示若你点选“本机磁盘(E:)”,则Tree Path为"资源管理器"-->"我的电脑"-->"本机磁盘(E:)"，因此利用TreePath的getLastPathComponent()方法就可以取得所点选的节点。*/

              		TreePath treepath = tree.getPathForRow(rowLocation);
              		TreeNode treenode = (TreeNode) treepath.getLastPathComponent(); 
        
              		nodeName = treenode.toString();
            	   }catch(NullPointerException ne){}
        	}
    	}
   	public static void main(String args[]) {
    
        	new TreeModelEventUse();
    	}
}
