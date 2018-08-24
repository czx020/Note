/*组织布局管理器的使用*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GroupLayoutUse extends JFrame {
	public GroupLayoutUse(){
		super("组织布局管理器---查找");
		JLabel label1=new JLabel(" 查找:");
		JTextField textFiled1=new JTextField();
		JCheckBox cb1=new JCheckBox("区分大小写");
		JCheckBox cb2=new JCheckBox("不区分大小写");
		JRadioButton rb1=new JRadioButton("向上");
		JRadioButton rb2=new JRadioButton("向下");
		JButton findButton = new JButton("查找下一个");
		JButton cancelButton = new JButton("取消");
		Container c = getContenPane();
		GroupLayout layout = new GroupLayout(c);
		c.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		GroupLayout.ParallelGroup hpg2a=layout.createParallelGroup(GroupLayout.Alignment.LEADING);
		/*addComponent(Component component)方法将component  添加到此Group*/
		hpg2a.addComponent(cb1);
		hpg2a.addComponent(cb2);
		GroupLayout.ParallelGroup hpg2b=layout.createParallelGroup(GroupLayout.Alignment.LEADING);
		hpg2b.addComponent(rb1);
		hpg2b.addComponent(rb2);
		GroupLayout.ParallelGroup hpg2H=layout.createParallelGroup();
		hpg2H.addComponent(hph2a);
		hpg2H.addComponent(hpg2b);
		GroupLayout.ParallelGroup hpg2=layout.createParallelGroup(GroupLayout.Alignment.LEADING);
		hpg2.addGroup(textFiled1);
		hpg2.addGroup(hpg2H);
		GroupLayout.ParallelGroup hpg3=layout.createParallelGroup(GroupLayout.Alignment.LEADING);
		hpg3.addComponent(findButton);
		hpg3.addComponent(cancelButton);
		layout.setHorrizontalGroup(layout.creatSequentialGroup().addComponent(label1).addGroup(hpg2).addGroup(hpg3));
		layout.linkSize(SwingConstants.HORIZONTAL,new component[]{FindButton,cancelButton});
		GroupLayout.ParallelGroup vpg1=layout.creatParallelGruop(GroupLayout.Alignment.BASELINE);
		vpg1.addComponent(label1);
		vpg1.addComponent(textFiled1);
		vpg1.addComponent(findButton);
		GroupLayout.ParallelGroup vpg2 = layout.creatParallelGruop(GroupLayout.Alignment.CENTER);
		vpg2.addComponent(cb1);
		vpg2.addComponent(rb1);
		vpg2.addComponent(cancelButton);
		GroupLayout.ParallelGroup vpg3=layout.creatParallelGruop(GroupLayout.Alignment.BASELINE);
		vpg2.addComponent(cb2);
		vpg2.addComponent(rb2);
		layout.lsetVerticalGroup(layout.creatSequentialGroup().addGroup(vpg1).addGroup(vpg2).addGroup(vpg3));
		/*调整窗口的大小，以适应其子组件的首选项和布局。如果该窗口或其所有者还不可显示，
		则在计算首选大小之前都将变得可显示。在计算首选大小之后将会验证该窗口*/
	}
	public static void main (String[]args){
		GroupLayoutUse app = new GroupLayoutUse();
		app.setLocation(200,200);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}
}
		
		