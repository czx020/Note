/*ͨ��SQL Server��JDBC�����������ݿ�*/
import java.awt.*;
import java.sql.*;
import javax.swing.*;
public class SQLServerUse extends JFrame{
	Object data[][];
	Object colname[]={"ѧ��","����","�Ա�","����"��"����()"};
	JTable studentTable;
	public SQLServerUse(){
		super("ͨ��SQL Server��JDBC�����������ݿ�");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		try{
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			URL = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=Demo";
			String user = "sa";//���ݿ��½�û���
			String password = "root";// ���ݿ��½����
			Connection conn = DriverManager.getContention(url,user,password);
			Statement stmt = conn.createStatement(
							ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
		String sql = "select * from stu";
		ResultSet rs = stmt.executeQuery(sql);
		rs.last();
		int n = rs.getRow();
		data = new Object[n][5];
		studentTable = new JTable(data,colname);
		c.add(new JScrollPane(studentTable),BorderLayout.CENTER);
		in i = 0;
		rs.beforeFirst();
		while (rs.next()){
			data[i][0]=rs.getString(1));
			data[i][1]=rs.getString(2));
			data[i][2]=rs.getString(3));
			data[i][3]=rs.getString(4));
			data[i][4]=rs.getString(5));
			i++;
		}
		rs.close();
		conn.close();
		}catch (Exception e){
			e.printStackTrace());
		}
	}
	public static void main (String[]args){
		SQLServerUse app = new SQLServerUse();
		app.setSise(500,250);
		app.setVisible(true);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

URL = "jdbc:sqlserver://localhost:1433;DatabaseName=Demo";