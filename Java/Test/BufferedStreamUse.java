/*����������ʹ��*/
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.util.Date;

public class BufferedStreamUse{
	private static String fileName = "D://��ҵ�������Ƕ�ʮ����.txt";
	public BufferedStreamUse(){
		try{
			int i = 0;
			int ch;
			//�����ǲ�������Ĳ���
			//������ȡ��ǰʱ��Ķ���
			Date d1 = new Date();
			FileInputStream f = new FileInputStream(fileName);
			//����ֵΪ-1ʱ�����ļ����ݶ�ȡ����
			while((ch = f.read())!=-1)
				i++;
			f.close();
			Date d2 = new Date();
			/*getTime������������Date�еķ��������ڻ�ȡ��ǰʱ�䣬��λΪ���롣��ȡ
			�ļ�ǰ�������ʱ������Ƕ�ȡ�ļ����õ�ʱ�䣬ͨ��ʱ��Ƚ�������������Ч�ʸߵ�*/
			long t = d2.getTime() - d1.getTime();
			//�����ȡ���ļ������С
			System.out.printf("��ȡ�ļ�%s(��%d�ֽ�)\n",fileName,i);
			//�����ȡ�ļ����õ�ʱ��
			System.out.printf("��������ķ�����Ҫ%1$ d����\n",t);
			//�����Ǵ�����Ĳ���
			i = 0;
			d1 = new Date();
			f = new FileInputStream(fileName);
			BufferedInputStream fb = new BufferedInputStream(f);
			while ((ch = fb.read())!=-1)
				i++;
			fb.close();
			d2 = new Date();
			t = d2.getTime() - d1.getTime();
			System.out.printf("������ķ�����Ҫ%1$ d����\n",t);
		}catch (Exception e){
			System.err.println(e);
		}
	}
	public static void main (String[]args){
		new BufferedStreamUse();
	}
}