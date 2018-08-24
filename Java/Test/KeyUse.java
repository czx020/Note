/*键盘事件处理的使用，能够获得焦点事件*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyUse  extends JFrame {
	public KeyUse(){
		super("键盘事件处理的使用");
		Container c = getContentPane();
		JTextArea ta = new JTextArea("",6,12);
		ta.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e){
				System.out.println("获得焦点");
			}
			public void focusLost(FocusEvent e){
				System.out.println("失去焦点");
			}
		}
		);
		ta.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e ){
				System.out.println("键盘事件:"+e.getKeyChar());
			}
		}
		);
		c.add(ta,BorderLayout.CENTER);
	}
	public static void main (String[]args){
		KeyUse app = new KeyUse();
		app.setSize(260,160);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}
}