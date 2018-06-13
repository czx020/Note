/*带缓存流的使用*/
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.util.Date;

public class BufferedStreamUse{
	private static String fileName = "D://毕业那年我们二十三岁.txt";
	public BufferedStreamUse(){
		try{
			int i = 0;
			int ch;
			//下面是不带缓存的操作
			//创建获取当前时间的对象
			Date d1 = new Date();
			FileInputStream f = new FileInputStream(fileName);
			//返回值为-1时代表文件数据读取结束
			while((ch = f.read())!=-1)
				i++;
			f.close();
			Date d2 = new Date();
			/*getTime（）方法是类Date中的方法，用于获取当前时间，单位为毫秒。读取
			文件前后的两个时间相减是读取文件所用的时间，通过时间比较评价两个流的效率高低*/
			long t = d2.getTime() - d1.getTime();
			//输出读取的文件及其大小
			System.out.printf("读取文件%s(共%d字节)\n",fileName,i);
			//输出读取文件所用的时间
			System.out.printf("不带缓存的方法需要%1$ d毫秒\n",t);
			//下面是带缓存的操作
			i = 0;
			d1 = new Date();
			f = new FileInputStream(fileName);
			BufferedInputStream fb = new BufferedInputStream(f);
			while ((ch = fb.read())!=-1)
				i++;
			fb.close();
			d2 = new Date();
			t = d2.getTime() - d1.getTime();
			System.out.printf("带缓存的方法需要%1$ d毫秒\n",t);
		}catch (Exception e){
			System.err.println(e);
		}
	}
	public static void main (String[]args){
		new BufferedStreamUse();
	}
}