/*interrupt()������ʹ�ã������ַ��Ĺ���*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InterruptUse extends JFrame{
	public InterruptUse(String[]texts) //texts����������Ҫ�����ַ���
	{
		super("interrupt()������ʹ��--�������");
		this.setSize(400,300);
		this.setLocation(300,260);
		//if��䣬������������һ���ַ���
		if(texts==null||texts.length==0)
			this.add(new RollbyJPanel("���ǰ���too young too simple"));
		else{
			this.setLayout(new GridLayout(texts.length,1));
			//���񲼾֣�һ��������
			for(int i = 0;i<texts.length;i++)
				this.add(new RollbyJPanel(texts[i]));
		}
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public InterruptUse(){
		this(null);
	}
	//�Զ����ڲ�˽������࣬ʵ���¼��������ӿں��߳̽ӿ�
	private class RollbyJPanel extends JPanel implements ActionListener,Runnable{
		private JTextField text_word;	//������
		private JTextField text_sleep;	//�߳�˯��
		private JButton button_start,button_interrupt;	//������ť�жϰ�ť
		private JTextField text_state;	//�߳�״̬
		private Thread thread_rollby;	//�̶߳���
		private int sleeptime;
		private RollbyJPanel(String text)	//�ڲ������Ĺ��췽��
		{
			this.setLayout(new GridLayout(2,1));
			for (int i = 0;i<100;i++)  //forѭ������Ϊ�ַ�����ӿո�
				text=text + "	";
				text_word=new JTextField(text);
				this.add(text_word);
				JPanel panel_sub = new JPanel(new FlowLayout(FlowLayout.LEFT));
				this.add(panel_sub);
				panel_sub.add(new JLabel("sleep"));
				//ʹ��math���е�rand��������һ��������������趨�̵߳�˯��ʱ��
				this.sleeptime=(int)(Math.random()*100);
				text_sleep=new JTextField(""+sleeptime,5);
				panel_sub.add(text_sleep);
				text_sleep.addActionListener(this);
				button_start=new JButton("����");
				panel_sub.add(button_start);
				button_start.addActionListener(this);
				button_interrupt=new JButton("�ж�");
				panel_sub.add(button_interrupt);
				button_interrupt.addActionListener(this);
				thread_rollby=new Thread(this);//�����̶߳���Ŀ������ǵ�ǰ����
				button_interrupt.setEnabled(false);//�����жΰ�ťΪ��Ч״̬
				panel_sub.add(new JLabel("state"));
				//���ó�ʼ�ı�������
				text_state=new JTextField(""+thread_rollby.getState(),10);
				text_state.setEditable(false);
				panel_sub.add(text_state);
}
public void run(){
	//�ж��߳��ǻ�Ĳ�δ���ж�
	while(thread_rollby.isAlive()&&! thread_rollby.isInterrupted())
	{
		try{
				String str=text_word.getText();
				str=str.substring(1)+str.substring(0,1);
				text_word.setText(str);
				thread_rollby.sleep(sleeptime);//�߳�˯�ߣ��׳��쳣
			}
			catch (InterruptedException e)	{
				break; //һ���ж����׳��쳣��������Ϊ�˳�ѭ��
			}
		}
	}
public void actionPerformed(ActionEvent e) //�¼�����
{
	if(e.getSource()==button_start)	//��������������ť�ǡ�
	{
		thread_rollby.start();
		text_state.setText(""+thread_rollby.getState());//��ʾ�߳�״̬
		button_start.setEnabled(false);//����������ťΪ���ɱ༭״̬
		button_interrupt.setEnabled(true);//�����жϰ�ťΪ���ɱ༭״̬
	}
	if(e.getSource()==button_interrupt) //d�����жϰ�ťʱ
	{
		thread_rollby.interrupt();//���õ�ǰ�̶߳����жϱ��
		text_state.setText(""+thread_rollby.getState());
		button_start.setEnabled(true);//����������ťΪ�ɱ༭״̬
		button_interrupt.setEnabled(false);//�����жϰ�ťΪ���ɱ༭״̬
		}
	}
}
public static void main (String[]args){
	String[]texts={"������һ��������ûȥ����","�Ҹ������ǣ���������ս,too young","too simple"};
	new InterruptUse(texts);
}
}
