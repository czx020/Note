/*�ı��༭���ʹ�ã����û���������*/

import javax.swing.JFrame;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class TextEditBox extends JFrame{
		public TextEditBox(){
		super ("�ı��༭���ʹ��");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		/*JTextFiled��Ĺ��췽��JTextFiled(String text ��int��int conlumns)�У�
		text�����ǳ�ʼ�ı���Ϣ
		columnsָ���ı��༭�Ŀ�ȡ�
		Jpasswordfield��Ĺ��췽����JTextField��Ĺ��췽������
		*/
		
		JTextField[] t ={new JTextField("�û���:",6),new JTextField("�������û���",16),new JTextField("�� ��:",6),new JPasswordField("123456",16)};
		
		/*JTextField���е�ɫͼEditable��boolean b)
		�������������ı��༭���Ƿ���Ա༭��bΪtrueʱ���ܱ༭�����򲻿ɱ༭��
		���ܱ༭ʱЧ�����Ʊ�ǩ��
		���⣬getText����������ȡ�ı���Ϣ��setText���������ı���Ϣ*/
		
		t[0].setEditable(false);
		t[2].setEditable(false);
		for (int i=0;i<4;i++) //ͨ��ѭ�����ı�����ӵ�������
			c.add(t[i]);
	} 
	public static void main (String[]args){
		TextEditBox app = new TextEditBox();
		app.setSize(300,200);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}
}

	