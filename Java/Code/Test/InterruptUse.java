/*interrupt()方法的使用，滚动字符的功能*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InterruptUse extends JFrame{
	public InterruptUse(String[]texts) //texts用来保存需要滚的字符串
	{
		super("interrupt()方法的使用--字体滚动");
		this.setSize(400,300);
		this.setLocation(300,260);
		//if语句，用于设置至少一行字符串
		if(texts==null||texts.length==0)
			this.add(new RollbyJPanel("你们啊，too young too simple"));
		else{
			this.setLayout(new GridLayout(texts.length,1));
			//网格布局，一行若干列
			for(int i = 0;i<texts.length;i++)
				this.add(new RollbyJPanel(texts[i]));
		}
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public InterruptUse(){
		this(null);
	}
	//自定义内部私有面板类，实现事件监听器接口和线程接口
	private class RollbyJPanel extends JPanel implements ActionListener,Runnable{
		private JTextField text_word;	//滚动字
		private JTextField text_sleep;	//线程睡眠
		private JButton button_start,button_interrupt;	//启动按钮中断按钮
		private JTextField text_state;	//线程状态
		private Thread thread_rollby;	//线程对象
		private int sleeptime;
		private RollbyJPanel(String text)	//内部面板类的构造方法
		{
			this.setLayout(new GridLayout(2,1));
			for (int i = 0;i<100;i++)  //for循环用于为字符串添加空格
				text=text + "	";
				text_word=new JTextField(text);
				this.add(text_word);
				JPanel panel_sub = new JPanel(new FlowLayout(FlowLayout.LEFT));
				this.add(panel_sub);
				panel_sub.add(new JLabel("sleep"));
				//使用math类中的rand（）生成一个随机数，用于设定线程的睡眠时间
				this.sleeptime=(int)(Math.random()*100);
				text_sleep=new JTextField(""+sleeptime,5);
				panel_sub.add(text_sleep);
				text_sleep.addActionListener(this);
				button_start=new JButton("启动");
				panel_sub.add(button_start);
				button_start.addActionListener(this);
				button_interrupt=new JButton("中断");
				panel_sub.add(button_interrupt);
				button_interrupt.addActionListener(this);
				thread_rollby=new Thread(this);//创建线程对象，目标对象是当前对象
				button_interrupt.setEnabled(false);//设置中段按钮为无效状态
				panel_sub.add(new JLabel("state"));
				//设置初始文本和列数
				text_state=new JTextField(""+thread_rollby.getState(),10);
				text_state.setEditable(false);
				panel_sub.add(text_state);
}
public void run(){
	//判断线程是活动的并未被中断
	while(thread_rollby.isAlive()&&! thread_rollby.isInterrupted())
	{
		try{
				String str=text_word.getText();
				str=str.substring(1)+str.substring(0,1);
				text_word.setText(str);
				thread_rollby.sleep(sleeptime);//线程睡眠，抛出异常
			}
			catch (InterruptedException e)	{
				break; //一旦中断则抛出异常，处理结果为退出循环
			}
		}
	}
public void actionPerformed(ActionEvent e) //事件处理
{
	if(e.getSource()==button_start)	//单击”启动“按钮是”
	{
		thread_rollby.start();
		text_state.setText(""+thread_rollby.getState());//显示线程状态
		button_start.setEnabled(false);//设置启动按钮为不可编辑状态
		button_interrupt.setEnabled(true);//设置中断按钮为不可编辑状态
	}
	if(e.getSource()==button_interrupt) //d单击中断按钮时
	{
		thread_rollby.interrupt();//设置当前线程对象中断标记
		text_state.setText(""+thread_rollby.getState());
		button_start.setEnabled(true);//设置启动按钮为可编辑状态
		button_interrupt.setEnabled(false);//设置中断按钮为不可编辑状态
		}
	}
}
public static void main (String[]args){
	String[]texts={"西方哪一个国家我没去过？","我告诉你们，我是身经百战,too young","too simple"};
	new InterruptUse(texts);
}
}
