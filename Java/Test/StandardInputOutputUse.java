/*��׼�����������ʹ��*/
import java.io.IOException;
public class StandardInputOutputUse{
	//�׳��쳣����java���������
	public static void main(String[]args) throws IOException{
		System.out.print("��Ӽ������������ݣ� ");
		byte buffer[]=new byte[512];//���ֽ�������Ϊ������
		//�ӱ�׼�������ж�ȡ�����ֽڵ�ָ��������������ʵ�ʶ�ȡ���ֽ���
		int count=System.in.read(buffer);
		System.out.print("ͨ����׼���������������ݣ� ");
		for (int i=0;i<=count;i++)
			//���ֽڷ�ʽ���buffer�е�Ԫ��ֵ
			System.out.print(""+buffer[i]);
			System.out.println();
			for (int i = 0;i<count;i++)
				//���ַ���ʽ���buffer�е�Ԫ��ֵ
				System.out.print((char) buffer[i]);
				//���ʵ�ʶ�ȡ���ֽ���
				System.out.println("count="+count);
	}
}