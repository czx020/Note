/*interrupt()方法的使用，滚动字符的功能*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InterruptUse extends JFfame{
	public InterruptUse(String[]texts) //texts用来保存需要滚的字符串
	{
		super("interrupt()方法的使用--字体滚动");
		this.setSize(400,300);
		this.setlocation(300,260);
		//if语句，用于设置至少一行字符串
		if(texts==null||texts.length==0)
			this.add(new RollbyJpanel("你们啊，too young too simple"));
		else{
			this.setLayout(new GirdLayout((texts.length,1));
			//网格布局，一行若干列
			for(int i = 0;i<texts.length;i++)
				this.add(new RollbyJpanel(texts[i]));
		}
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public InterruptUse(){
		this(null);
	}
	//自定义内部私有面板类，实现事件监听器接口和线程接口
	private class RollbyJpanel extends JPanel implements ActionListener.Runnable{
		private JTextField text_word;//滚动字
		private JTextField text_sleep;//线程睡眠
		private JButton button_start,button_interrupt;//启动按钮中断按钮
		private JTextField text_state;//线程状态
		private Thread thread_rollby;//线程对象
		private int sleeptime;
		private RollbyJpanel(String text)//内部面板类的构造方法
		{
			this.setLayout(new GridLayout(2,1));
			for (int i = 0,i<100;i++)//for循环用于为字符串添加空格
				text=text+" ";
				text_word=new JTextField(text);
				this.add(text_word);
				JPanel panel_sub = new JPanel(new FlowLayout(FlowLayout.LEFT));
				this.add(panel_sub);
				panel_sub.add(new JLabel("sleep"));
				//使用math类中的rand（）生成一个随机数，用于设定线程的睡眠时间
				this.sleeptime=(int))Math.rand()*100);
				text_sleep=new JTextField("'+sleeptime,5);
				panel_sub.add(text_sleep);
				text_sleep.addActionListener(this);
				button_start=new JButton("启动");
				panel_sub.add(button_start);
				panel_sub.addActionListener(this);
				button_interrupt=new JButton("中断");
				