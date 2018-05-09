/*使用匿名类实现时间处理的简单应用*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventHandlingUse1 extends JFrame{
	public EventHandlingUse1 () {
		super("匿名类实现时间处理的简单应用");
		Container c = getContentPane();
		JButton b = new JButton("单击0次");
		b.addActionListener(new ActionListener(){
			int count = 0;
			public void actionPerformed(ActionEvent e){
				JButton b = (JButton)e.getSource();
				b.setText("单击"+(++count)+"次");
			}	//actionPerformed（）方法结束
		}		//实现接口ActiionListenter的匿名类结束
		); //addActionListener（）方法结束
		/*注释部分使用了内部类
		ButtonHandler bh = new ButtonHandler();
		b.addActionListener(bh);
		class ButtonHandler implements ActionListener{
			int count = 0;
			public void actionPerformed(ActionEvent e){
				JButton b = (JButton)e.getSource();
				Button b = (JButton)e.getSource();
				b.setText("单击"+(++count)+"次");
					b.setText("单击"+(++count)+"次");
			}	//actionPerformed（）方法结束
		}		//ButtonHandler类结束
*/
/*JFrame默认的布局管理器是BorderLayout，未调用色图Layout()方法就表示使用的是默认的布局管理器*/
c.add(b,BorderLayout.CENTER);
	}
	public static void main (String[]args){
		EventHandlingUse1 app = new EventHandlingUse1();
		app.setSize(160,120);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}
}