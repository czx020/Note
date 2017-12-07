
public class Zhipai 
{
	public static void main(String[] args) {
		int i,j;
		int[] data = new int[53];
		System.out.println("温馨提示:欢迎进入纸牌游戏!");

		for(i=1;i<=52;i++)
		{
			data[i]=1;//录入52张牌的编号。
		}
		for(j=2;j<=52;j++)//外循环，基数循环。
		{
			for(i=j;i<=52;i++)//内循环，基数倍数条件判断。
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
				System.out.println("向上的牌：   "+i);
		}
	}
}