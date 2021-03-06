
/*
 	功能简介：TreeSelectionEvent的使用,能够读取数据。
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
        JFrame app=new JFrame("TreeSelectionEvent的使用");
        Container c=app.getContentPane();
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("资源管理器");
        DefaultMutableTreeNode node = new DefaultMutableTreeNode("DefaultMutableTreeNodeTree.java");
        root.add(node);
        node = new DefaultMutableTreeNode("TreeModelTree.java");
        root.add(node);
        node = new DefaultMutableTreeNode("TreeModelEventUse.java");
        root.add(node);
        node = new DefaultMutableTreeNode("EditTree.java");
        root.add(node);
        
        JTree tree = new JTree(root);
        //设置Tree的选择模式为一次只能选择一个节点
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        //检查是否有TreeSelectionEvent事件
        tree.addTreeSelectionListener(this);

        //下面五行，JSplitPane中，左边是放含有JTree的JScrollPane,右边是放JEditorPane
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
    //本方法实作valueChanged()方法
    public void valueChanged(TreeSelectionEvent e){
        JTree tree = (JTree) e.getSource(); 
        //利用JTree的getLastSelectedPathComponent()方法取得目前选取的节点
        DefaultMutableTreeNode selectionNode =
            (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();

        String nodeName = selectionNode.toString();
        
        //判断是否为树叶节点，若是则显示文件内容，若不是则不做任何事
        if (selectionNode.isLeaf())
	{
           /*取得文件的位置路径,System.getProperty("user.dir")可以取得目前工作的路径，System.getProperty("file.separator")是取得文件分隔符，例如在window环境的文件分陋符是"\"。*/
            String filepath="file:"+System.getProperty("user.dir")+System.getProperty("file.separator")+nodeName;
                           
            try {
                //利用JEditorPane的setPage()方法将文件内容显示在editorPane中。若文件路径错误，则会产生IOException
                 editorPane.setPage(filepath);
            } catch(IOException ex) {
                 System.out.println("找不到此文件");
            }
        }
    }   
    public static void main(String[] args) {
       
        new TreeSelectionEventUse();        
    }
}              

