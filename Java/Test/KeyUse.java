/*�����¼������ʹ�ã��ܹ���ý����¼�*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyUse  extends JFrame {
	public KeyUse(){
		super("�����¼������ʹ��");
		Container c = getContentPane();
		JTextArea ta = new JTextArea("",6,12);
		ta.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e){
				System.out.println("��ý���");
			}
			public void focusLost(FocusEvent e){
				System.out.println("ʧȥ����");
			}
		}
		);
		ta.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e ){
				System.out.println("�����¼�:"+e.getKeyChar());
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