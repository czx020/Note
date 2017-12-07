import java.util.Scanner;

public class Max
{
    
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int[] n = new int[10];
        System.out.println("请输入第10个整数:");
        for (int i = 0; i < 10; i++)
        {
            n[i] = input.nextInt();
        }
        System.out.println("----------统计中----------------");
        // 输出
        int max;
        max  = n[0];
        for (int i = 0; i < n.length; i++)
        {
            if (max < n[i])
            {
                max = n[i];
            }
          
        }
        System.out.println("最大值:" + max);
        input.close();

    }
}