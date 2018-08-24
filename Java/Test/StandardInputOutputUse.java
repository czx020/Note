/*标准输入输出流的使用*/
import java.io.IOException;
public class StandardInputOutputUse{
	//抛出异常交由java虚拟机处理
	public static void main(String[]args) throws IOException{
		System.out.print("请从键盘上输入数据： ");
		byte buffer[]=new byte[512];//以字节数组作为缓冲区
		//从标准输入流中读取若干字节到指定缓冲区，返回实际读取的字节数
		int count=System.in.read(buffer);
		System.out.print("通过标准的输出流输出的数据： ");
		for (int i=0;i<=count;i++)
			//按字节方式输出buffer中的元素值
			System.out.print(""+buffer[i]);
			System.out.println();
			for (int i = 0;i<count;i++)
				//按字符方式输出buffer中的元素值
				System.out.print((char) buffer[i]);
				//输出实际读取的字节数
				System.out.println("count="+count);
	}
}