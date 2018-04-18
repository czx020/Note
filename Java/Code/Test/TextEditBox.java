/*文本编辑框的使用，有用户名和密码*/

import javax.swing.JFrame;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class TextEditBox extends JFrame{
		public TextEditBox(){
		super ("文本编辑框的使用");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		/*JTextFiled类的构造方法JTextFiled(String text ，int，int conlumns)中，
		text参数是初始文本信息
		columns指定文本编辑的宽度。
		Jpasswordfield类的构造方法和JTextField类的构造方法相似
		*/
		
		JTextField[] t ={new JTextField("用户名:",6),new JTextField("请输入用户名",16),new JTextField("密 码:",6),new JPasswordField("123456",16)};
		
		/*JTextField类中的色图Editable（boolean b)
		方法用于设置文本编辑框是否可以编辑。b为true时可能编辑，否则不可编辑。
		不能编辑时效果类似标签。
		另外，getText（）方法获取文本信息，setText（）设置文本信息*/
		
		t[0].setEditable(false);
		t[2].setEditable(false);
		for (int i=0;i<4;i++) //通过循环把文本框添加到容器中
			c.add(t[i]);
	} 
	public static void main (String[]args){
		TextEditBox app = new TextEditBox();
		app.setSize(300,200);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}
}

	