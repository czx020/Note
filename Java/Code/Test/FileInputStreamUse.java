/*ʹ��FileinputStreamUse���ȡ�ļ��е����ݲ����������̨�����ͳ���ļ���ռ���ּ���*/
import java.io.FileInputStream;
import java.io.IOException;
public class FileInputStreamUse{
	public FileInputStreamUse(){
		try{
			/*
			ͨ�����췽��ʵ����һ���ļ�����������Ҫ���ʵ��ļ���Դ�ļ���ͬһ�����У�
			������Ҫʹ�þ���·����*/
			FileInputStream f = new FileInputStream("D:/V6.0/text.txt");
			int i;
			//��ȡ�ļ�������
			int b = f.read();
			//����ļ������ݶ�ȡ��ϡ�����ֵ���ǣ�������ʾ��ȡ�ļ����
			for (i = 0;b!=-1;i++){
				System.out.print((char)b);
				b = f.read();
			}
			System.out.println();
			System.out.println("�ļ��ֽ���Ϊ"+i);
			f.close();
		}catch (IOException e){
			System.err.println(e);
		}
	}
	public static void main (String[]args){
		new FileInputStreamUse();
	}
}