/*ʹ�ãϣ���������ӣ���������ڿ���̨�������*/
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamUse{
	public OutputStreamUse(OutputStream out){
		String s = "��ĸ�����ߣ����������¡��������ܷ죬��ֳٳٹ顣˭�Դ���ģ�����������.";
		byte[] b = s.getBytes();
		try{
			// ���ֽ������д���������
			out.write(b);
			//�ѻ������������ǿ�����
			out.flush();
		}catch (IOException e){
			System.err.print(e);
		}
	}
	public static void main (String[]args){
		new OutputStreamUse(System.out);
	}
}