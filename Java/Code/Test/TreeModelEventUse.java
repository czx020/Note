
/*
 ���ܼ�飺TreeModelEvent�¼���ʹ�á�
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

public class TreeModelEventUse implements TreeModelListener{
	JLabel label = null;
	String nodeName = null; //ԭ�нڵ�����	
	public TreeModelEventUse(){
		JFrame app=new JFrame("TreeModelEvent�¼���ʹ��");
        	Container c=app.getContentPane();
        	c.setLayout(new BorderLayout());
        	DefaultMutableTreeNode root = new DefaultMutableTreeNode("��Դ������");
        	DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("�ļ���");
        	DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("�ҵĵ���");
        	DefaultMutableTreeNode node3 = new DefaultMutableTreeNode("�ղؼ�");
        	root.add(node1);
        	root.add(node2);
        	root.add(node3);
       
        	DefaultMutableTreeNode leafnode = new DefaultMutableTreeNode("��˾�ļ�");
        	node1.add(leafnode);
        	leafnode = new DefaultMutableTreeNode("�����ż�");
        	node1.add(leafnode);
        	leafnode = new DefaultMutableTreeNode("˽���ļ�");
        	node1.add(leafnode);
        
        	leafnode = new DefaultMutableTreeNode("��������(C:)");
        	node2.add(leafnode);
       		leafnode = new DefaultMutableTreeNode("��������(D:)");
        	node2.add(leafnode);
        	leafnode = new DefaultMutableTreeNode("��������(E:)");
        	node2.add(leafnode);
        
        	DefaultMutableTreeNode node31 = new DefaultMutableTreeNode("��վ�б�");
        	node3.add(node31);
        
        	leafnode = new DefaultMutableTreeNode("�廪��ѧ������");
        	node31.add(leafnode);
        	leafnode = new DefaultMutableTreeNode("֣���ṤҵѧԺ");
        	node31.add(leafnode);
        	leafnode = new DefaultMutableTreeNode("�������");
        	node31.add(leafnode);
        
        	JTree tree = new JTree(root);
		//����JTreeΪ�ɱ༭��
        	tree.setEditable(true);
		//ʹTree������Mouse�¼����Ա�ȡ�ýڵ����� 
        	tree.addMouseListener(new MouseHandle());
        	//��������ȡ��DefaultTreeModel,������Ƿ���TreeModelEvent�¼�.
        	DefaultTreeModel treeModel = (DefaultTreeModel)tree.getModel();
        	treeModel.addTreeModelListener(this);
        
        	JScrollPane scrollPane=new JScrollPane();
        	scrollPane.setViewportView(tree);
        
        	label=new JLabel("��������Ϊ: ");
        	c.add(scrollPane,BorderLayout.CENTER);
        	c.add(label,BorderLayout.SOUTH);
        	app.pack();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	app.setVisible(true);
    	}
    /*������ʵ��TreeModelListener�ӿڣ����ӿڹ������ĸ��������ֱ���TreeNodesChanged()��treeNodesInserted()��treeNodesRemoved()��treeNodesRemoved()��treeStructureChanged()���ڴ˷�����ֻ��Ը��Ľڵ�ֵ�Ĳ��ݣ����ֻʵ��treeNodesChanged()������*/
	public void treeNodesChanged(TreeModelEvent e){
		TreePath treePath=e.getTreePath();
		System.out.println(treePath);
        /*����������TreeModelEventȡ�õ�DefaultMutableTreeNodeΪ�ڵ�ĸ��ڵ㣬�������û���ѡ�Ľڵ㣬������Ҫ�ر�ע�⡣Ҫȡ�������Ľڵ���Ҫ�ټ�д����6�д��롣*/
        	DefaultMutableTreeNode node=(DefaultMutableTreeNode)treePath.getLastPathComponent();
        	try {
            	/*getChildIndices()�����᷵��Ŀǰ�޸Ľڵ������ֵ������ֻ�޸�һ���ڵ㣬��˽ڵ�����ֵ�ͷ���index[0]��λ�ã�����ѡ�Ľڵ�Ϊroot node,��getChildIndices()�ķ���ֵΪnull����������ĵڶ��о��ڴ����ѡroot node������NullPointerException���⡣*/
            		int[] index=e.getChildIndices();
              		//��DefaultMutableTreeNode���getChildAt()����ȡ���޸ĵĽڵ����
            		node = (DefaultMutableTreeNode)node.getChildAt(index[0]);
        	} catch (NullPointerException exc) {}
        	//��DefaultMutableTreeNode��getUserObject()����ȡ�ýڵ�����ݣ�����д��node.toString()����ͬ
        	label.setText(nodeName+"��������Ϊ:"+(String)node.getUserObject());
    	}
    	public void treeNodesInserted(TreeModelEvent e){}
    	public void treeNodesRemoved(TreeModelEvent e){}
    	public void treeStructureChanged(TreeModelEvent e){}

 
    	//����Mouse��ѡ�¼�
    	class MouseHandle extends MouseAdapter{
        	public void mousePressed(MouseEvent e){
            	    try{
              		JTree tree = (JTree)e.getSource();
        /*JTree��getRowForLocation()�����᷵�ؽڵ��������ֵ�����籾���У�����������(D:)����������ֵΪ4��������ֵ�������������ݼеĴ򿪻��������֧��������Դ����������������ֵ��Ϊ0��*/ 
              	        int rowLocation = tree.getRowForLocation(e.getX(),e.getY());
             	/*JTree��getPathForRow()������ȡ�ô�root node����ѡ�ڵ��һ��path����pathΪһ��ֱ�ߣ���������е�ͼʾ�����ѡ����������(E:)��,��Tree PathΪ"��Դ������"-->"�ҵĵ���"-->"��������(E:)"���������TreePath��getLastPathComponent()�����Ϳ���ȡ������ѡ�Ľڵ㡣*/

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
