/*ʹ��FileoutputStream�������������ļ��У���������д���ļ�*/
import java.io.FileOutputStream;
import java.io.IOException;
public class FileOutputStreamUse{
	public FileOutputStreamUse(){
		String s="��־�ߣ��¾��ɣ��Ƹ����ۣ��ٶ��ع����������������첻������н��������ǧԽ�׿����⡣";
		byte[] b = s.getBytes();
		try{
			/*ʵ����һ���ļ�������������У����������Ͳ���"�������������������ļ���������ļ���
			ָ��·�����Ѵ��ڣ��͸�����������ݡ�������ָ��λ���½���Ҳ����ʹ�����صķ���FileoutputStream9string name,
			bo0lean append��ָ��׷�ӷ�ʽ��ʵ�����ı�ĩβ׷������*/
			FileOutputStream f = new FileOutputStream("E:/������.txt");
			f.write(b);
			f.flush();
			f.close();
		}catch (IOException e){
			System.out.println(e);
		}
	}
public static void main (String[]args){
		new FileOutputStreamUse();
}
}		