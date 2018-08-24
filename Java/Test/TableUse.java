
/*

 	���ܼ�飺����ʹ�á�
*/
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.Vector;

public class TableUse extends JFrame{
    //DefaultTableModel m_data;
    //JTable m_view;
    DefaultTableModel dt;
    JTable table;
    public TableUse(){
        super("����ʹ��");
        Container c=getContentPane();
        c.setLayout(new FlowLayout());
        //int i;

        // �����ĸ���ť
        JButton[] b={
		     new JButton("�����"), new JButton("�����"),
                     new JButton("ɾ����"), new JButton("ɾ����")
                     };
	//ͨ��for�����ӵ�����c��
        for (int i=0;i<4;i++)
            c.add(b[i]);
	//����һ���յ����ݱ��
        dt= new DefaultTableModel();
	//ͨ������ģ�ʹ������ 
        table= new JTable(dt);
	//���ñ����ʾ����Ĵ�С
        table.setPreferredScrollableViewportSize(new Dimension(360,160)); 
	//���ñ���п��ڱ������ʱ���Զ�����ģʽ
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	//��ӹ�������
        JScrollPane sPane = new JScrollPane(table);
        c.add(sPane);
	//�԰�ť�Ӽ���
        b[0].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
		    //���÷���
                    addRow();
                    System.out.println("���һ��");
                } //actionPerformed()��������
            } //ʵ�ֽӿ�ActionListener���ڲ������
        ); //addActionListener()��������
        b[1].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
		    //���÷���
                    addColumn();
                    System.out.println("���һ��");
                } 
            } 
        ); 
        b[2].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
		    //���÷���
                    deleteRow();
                    System.out.println("ɾ����ǰ��");
                } 
            } 
        ); 
        b[3].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    //���÷���
                    deleteColumn( );
                    System.out.println("ɾ����ǰ��");
                } 
            } 
        ); 
    } 
    // �÷������������һ��
    public void addColumn(){
	//��ö�ά��������
        int cNum=dt.getColumnCount();
	//��ȡ��ά��������
        int rNum=dt.getRowCount();
        String s="��"+(cNum+1);
	//���ص�һ��ѡ���е�����
        int c =table.getSelectedColumn();
        System.out.println( "��ǰ�к�Ϊ:"+c);
        if (cNum==0||rNum==0||c<0)
        {
            dt.addColumn(s);
            return;
        } 
        c++;
	//���÷������б�ͷ�Ĵ���
        Vector<String> vs=getColumnNames(); 
        vs.add(c,s);
        Vector data=dt.getDataVector();
        for (int i=0;i<data.size( );i++)
        {
            Vector e=(Vector) data.get(i);
            e.add(c, new String(""));
        } 
        dt.setDataVector(data, vs);
    } // addColumn()��������
    //�÷����������һ��
    public void addRow() {
        int cNum=dt.getColumnCount();
        if (cNum==0)
            addColumn( );
        int rNum=dt.getRowCount( );
        int r=getRowCurrent( );
        System.out.println("��ǰ�к�Ϊ:"+ r);
        dt.insertRow(r,(Vector)null );
    } // addRow��������
    //�÷�������ɾ��һ��
    public void deleteColumn(){
        int cNum=dt.getColumnCount();
        if (cNum==0)
            return;
        int c=table.getSelectedColumn( );
        if (c<0)
            c = 0;
        System.out.println( "��ǰ�к�Ϊ:"+ c);
	//���÷����Ա�ͷ�Ľ��д���
        Vector<String> vs=getColumnNames(); 
        vs.remove(c);
        Vector data=dt.getDataVector( );
        for (int i=0;i<data.size( ); i++)
        {
            Vector e = (Vector) data.get(i);
            e.remove(c);
        } 
        dt.setDataVector(data, vs);
    } //deleteColumn()��������
    //�÷�������ɾ��һ��
    public void deleteRow(){
        int rNum=dt.getRowCount();
        if (rNum>0)
        {
            int rEdit=getRowCurrent();
            dt.removeRow(rEdit);
        }
    } //deleteRow()��������
    //�÷�������ȡ��������
    public Vector<String> getColumnNames(){
        Vector<String> vs=new Vector<String>();
        int cNum=dt.getColumnCount( );
        for(int i=0;i<cNum; i++)
            vs.add(dt.getColumnName(i));
        return(vs);
    } //getColumnNames()��������
    //�÷�������ȡ�õ�ǰ�е��к�
    public int getRowCurrent(){
        int r=table.getSelectedRow();
        if (r<0)
            r=0;
        return(r);
    } //getRowCurrent()��������     
    public static void main(String args[]){
        TableUse app=new TableUse( );
 	app.setSize(360,260);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    } 
} 
