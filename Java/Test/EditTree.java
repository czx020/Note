
/*
 
 	功能简介：对结点增加、删除和修改。
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

public class EditTree implements ActionListener,TreeModelListener{
  JLabel label=null;
  JTree  tree=null;
  DefaultTreeModel treeModel=null;
  String nodeName=null;//原有节点名称
  
  public EditTree(){      
    JFrame app=new JFrame("树结点的编辑");
    Container c=app.getContentPane();
    c.setLayout(new BorderLayout());

    DefaultMutableTreeNode root=new DefaultMutableTreeNode("资源管理器"); 
    
    tree=new JTree(root);
    tree.setEditable(true);
    tree.addMouseListener(new MouseHandle());
    treeModel=(DefaultTreeModel)tree.getModel();
    treeModel.addTreeModelListener(this);
    
    JScrollPane scrollPane=new JScrollPane();
    scrollPane.setViewportView(tree);
    
    JPanel panel=new JPanel();
    JButton b=new JButton("新增节点");
    b.addActionListener(this);
    panel.add(b);
    b=new JButton("删除节点");
    b.addActionListener(this);
    panel.add(b);
    b=new JButton("清除所有节点");
    b.addActionListener(this);
    panel.add(b);
    
    label=new JLabel("Action");
    c.add(panel,BorderLayout.NORTH);
    c.add(scrollPane,BorderLayout.CENTER);
    c.add(label,BorderLayout.SOUTH);
    app.pack();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app.setVisible(true);
    
  } 
  //本方法运行新增、删除、清除所有节点的程序代码
  public void actionPerformed(ActionEvent ae){
  	if (ae.getActionCommand().equals("新增节点")){
  		DefaultMutableTreeNode parentNode=null;
  		DefaultMutableTreeNode newNode=new DefaultMutableTreeNode("新节点");
  		newNode.setAllowsChildren(true);
  		TreePath parentPath=tree.getSelectionPath();
          
         	//取得新节点的父节点
  		parentNode=(DefaultMutableTreeNode)(parentPath.getLastPathComponent());

         	//由DefaultTreeModel的insertNodeInto（）方法增加新节点
  		treeModel.insertNodeInto(newNode,parentNode,parentNode.getChildCount());

         /*tree的scrollPathToVisible()方法在使Tree会自动展开文件夹以便显示所加入的新节点。若没加这行则加入的新节点会被 包在文件夹中，你必须自行展开文件夹才看得到。*/
  	tree.scrollPathToVisible(new TreePath(newNode.getPath()));  
  	label.setText("新增节点成功");
  	}
  	if (ae.getActionCommand().equals("删除节点")){
  		TreePath treepath=tree.getSelectionPath();
  		if (treepath!=null){
          	//下面两行取得选取节点的父节点
    		DefaultMutableTreeNode selectionNode=(DefaultMutableTreeNode)treepath.getLastPathComponent();
    		TreeNode parent=(TreeNode)selectionNode.getParent();
    		if (parent!=null) {
             		//由DefaultTreeModel的removeNodeFromParent()方法删除节点，包含它的子节点。
    			treeModel.removeNodeFromParent(selectionNode);
    			label.setText("删除节点成功");
    		}
  	}  
     }
  	if (ae.getActionCommand().equals("清除所有节点")){

        	//下面一行，由DefaultTreeModel的getRoot()方法取得根节点
 		 DefaultMutableTreeNode rootNode=(DefaultMutableTreeNode)treeModel.getRoot();

       		 //下面一行删除所有子节点.
  		rootNode.removeAllChildren();   

        	//删除完后务必运行DefaultTreeModel的reload()操作，整个Tree的节点才会真正被删除.     
  		treeModel.reload();
  		label.setText("清除所有节点成功");
  	}
      }
     public void treeNodesChanged(TreeModelEvent e){
     	TreePath treePath=e.getTreePath();
     	DefaultMutableTreeNode node=(DefaultMutableTreeNode)treePath.getLastPathComponent();
     	try{
       		int[] index=e.getChildIndices();
       		node=(DefaultMutableTreeNode)node.getChildAt(index[0]); 
     	}catch(NullPointerException exc){}
       label.setText(nodeName+"更改数据为:"+(String)node.getUserObject());
     }
  public void treeNodesInserted(TreeModelEvent e){
     System.out.println("new node insered");     
  }
  public void treeNodesRemoved(TreeModelEvent e){
     System.out.println("node deleted"); 
  }
  public void treeStructureChanged(TreeModelEvent e){
     System.out.println("Structrue changed"); 
  }
    class MouseHandle extends MouseAdapter{
      public void mousePressed(MouseEvent e){
         try{
           JTree tree=(JTree)e.getSource();
           int rowLocation=tree.getRowForLocation(e.getX(),e.getY());
           TreePath treepath=tree.getPathForRow(rowLocation); 
           TreeNode treenode=(TreeNode)treepath.getLastPathComponent();
           nodeName=treenode.toString();           
         }catch(NullPointerException ne){}
      } 
    }
   public static void main(String[] args){
      new EditTree(); 
    }
    
} 

