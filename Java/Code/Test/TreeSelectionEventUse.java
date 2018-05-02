
/*
 	���ܼ�飺TreeSelectionEvent��ʹ��,�ܹ���ȡ���ݡ�
*/
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import java.util.*;

public class TreeSelectionEventUse implements TreeSelectionListener{
    JEditorPane editorPane;
    public TreeSelectionEventUse(){
        JFrame app=new JFrame("TreeSelectionEvent��ʹ��");
        Container c=app.getContentPane();
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("��Դ������");
        DefaultMutableTreeNode node = new DefaultMutableTreeNode("DefaultMutableTreeNodeTree.java");
        root.add(node);
        node = new DefaultMutableTreeNode("TreeModelTree.java");
        root.add(node);
        node = new DefaultMutableTreeNode("TreeModelEventUse.java");
        root.add(node);
        node = new DefaultMutableTreeNode("EditTree.java");
        root.add(node);
        
        JTree tree = new JTree(root);
        //����Tree��ѡ��ģʽΪһ��ֻ��ѡ��һ���ڵ�
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        //����Ƿ���TreeSelectionEvent�¼�
        tree.addTreeSelectionListener(this);

        //�������У�JSplitPane�У�����Ƿź���JTree��JScrollPane,�ұ��Ƿ�JEditorPane
        JScrollPane scrollPane1 = new JScrollPane(tree);
        editorPane = new JEditorPane();
        JScrollPane scrollPane2 = new JScrollPane(editorPane);
        JSplitPane splitPane = new JSplitPane(
        JSplitPane.HORIZONTAL_SPLIT,true, scrollPane1, scrollPane2);

        c.add(splitPane);
        app.pack();
	app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);   
    }
    //������ʵ��valueChanged()����
    public void valueChanged(TreeSelectionEvent e){
        JTree tree = (JTree) e.getSource(); 
        //����JTree��getLastSelectedPathComponent()����ȡ��Ŀǰѡȡ�Ľڵ�
        DefaultMutableTreeNode selectionNode =
            (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();

        String nodeName = selectionNode.toString();
        
        //�ж��Ƿ�Ϊ��Ҷ�ڵ㣬��������ʾ�ļ����ݣ������������κ���
        if (selectionNode.isLeaf())
	{
           /*ȡ���ļ���λ��·��,System.getProperty("user.dir")����ȡ��Ŀǰ������·����System.getProperty("file.separator")��ȡ���ļ��ָ�����������window�������ļ���ª����"\"��*/
            String filepath="file:"+System.getProperty("user.dir")+System.getProperty("file.separator")+nodeName;
                           
            try {
                //����JEditorPane��setPage()�������ļ�������ʾ��editorPane�С����ļ�·������������IOException
                 editorPane.setPage(filepath);
            } catch(IOException ex) {
                 System.out.println("�Ҳ������ļ�");
            }
        }
    }   
    public static void main(String[] args) {
       
        new TreeSelectionEventUse();        
    }
}              

