/*interrupt()������ʹ�ã������ַ��Ĺ���*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InterruptUse extends JFfame{
	public InterruptUse(String[]texts) //texts����������Ҫ�����ַ���
	{
		super("interrupt()������ʹ��--�������");
		this.setSize(400,300);
		this.setlocation(300,260);
		//if��䣬������������һ���ַ���
		if(texts==null||texts.length==0)
			this.add(new RollbyJpanel("���ǰ���too young too simple"));
		else{
			this.setLayout(new GirdLayout((texts.length,1));
			//���񲼾֣�һ��������
			for(int i = 0;i<texts.length;i++)
				this.add(new RollbyJpanel(texts[i]));
		}
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public InterruptUse(){
		this(null);
	}
	//�Զ����ڲ�˽������࣬ʵ���¼��������ӿں��߳̽ӿ�
	private class RollbyJpanel extends JPanel implements ActionListener.Runnable{
		private JTextField text_word;//������
		private JTextField text_sleep;//�߳�˯��
		private JButton button_start,button_interrupt;//������ť�жϰ�ť
		private JTextField text_state;//�߳�״̬
		private Thread thread_rollby;//�̶߳���
		private int sleeptime;
		private RollbyJpanel(String text)//�ڲ������Ĺ��췽��
		{
			this.setLayout(new GridLayout(2,1));
			for (int i = 0,i<100;i++)//forѭ������Ϊ�ַ�����ӿո�
				text=text+" ";
				text_word=new JTextField(text);
				this.add(text_word);
				JPanel panel_sub = new JPanel(new FlowLayout(FlowLayout.LEFT));
				this.add(panel_sub);
				panel_sub.add(new JLabel("sleep"));
				//ʹ��math���е�rand��������һ��������������趨�̵߳�˯��ʱ��
				this.sleeptime=(int))Math.rand()*100);
				text_sleep=new JTextField("'+sleeptime,5);
				panel_sub.add(text_sleep);
				text_sleep.addActionListener(this);
				button_start=new JButton("����");
				panel_sub.add(button_start);
				panel_sub.addActionListener(this);
				button_interrupt=new JButton("�ж�");
				