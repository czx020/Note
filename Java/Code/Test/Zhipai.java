
public class Zhipai 
{
	public static void main(String[] args) {
		int i,j;
		int[] data = new int[53];
		System.out.println("��ܰ��ʾ:��ӭ����ֽ����Ϸ!");

		for(i=1;i<=52;i++)
		{
			data[i]=1;//¼��52���Ƶı�š�
		}
		for(j=2;j<=52;j++)//��ѭ��������ѭ����
		{
			for(i=j;i<=52;i++)//��ѭ�����������������жϡ�
			{
				if(i%j==0)
				{if(data[i]==0)
			           data[i]=1;
		                 else
			           data[i]=0;}
			} 
		}
		for (i=1;i<=52;i++)
		{
			if(data[i]==1)
				System.out.println("���ϵ��ƣ�   "+i);
		}
	}
}