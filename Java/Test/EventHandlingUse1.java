/*ʹ��������ʵ��ʱ�䴦��ļ�Ӧ��*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventHandlingUse1 extends JFrame{
	public EventHandlingUse1 () {
		super("������ʵ��ʱ�䴦��ļ�Ӧ��");
		Container c = getContentPane();
		JButton b = new JButton("����0��");
		b.addActionListener(new ActionListener(){
			int count = 0;
			public void actionPerformed(ActionEvent e){
				JButton b = (JButton)e.getSource();
				b.setText("����"+(++count)+"��");
			}	//actionPerformed������������
		}		//ʵ�ֽӿ�ActiionListenter�����������
		); //addActionListener������������
		/*ע�Ͳ���ʹ�����ڲ���
		ButtonHandler bh = new ButtonHandler();
		b.addActionListener(bh);
		class ButtonHandler implements ActionListener{
			int count = 0;
			public void actionPerformed(ActionEvent e){
				JButton b = (JButton)e.getSource();
				Button b = (JButton)e.getSource();
				b.setText("����"+(++count)+"��");
					b.setText("����"+(++count)+"��");
			}	//actionPerformed������������
		}		//ButtonHandler�����
*/
/*JFrameĬ�ϵĲ��ֹ�������BorderLayout��δ����ɫͼLayout()�����ͱ�ʾʹ�õ���Ĭ�ϵĲ��ֹ�����*/
c.add(b,BorderLayout.CENTER);
	}
	public static void main (String[]args){
		EventHandlingUse1 app = new EventHandlingUse1();
		app.setSize(160,120);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}
}