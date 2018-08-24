/*使用FileinputStreamUse类读取文件中的数据并输出到控制台，最后统计文件所占的字计数*/
import java.io.FileInputStream;
import java.io.IOException;
public class FileInputStreamUse{
	public FileInputStreamUse(){
		try{
			/*
			通过构造方法实例化一个文件输入流对象，要访问的文件和源文件在同一个包中，
			所以需要使用绝对路径。*/
			FileInputStream f = new FileInputStream("D:/V6.0/text.txt");
			int i;
			//读取文件的数据
			int b = f.read();
			//如果文件的数据读取完毕。返回值就是－１，表示读取文件完毕
			for (i = 0;b!=-1;i++){
				System.out.print((char)b);
				b = f.read();
			}
			System.out.println();
			System.out.println("文件字节数为"+i);
			f.close();
		}catch (IOException e){
			System.err.println(e);
		}
	}
	public static void main (String[]args){
		new FileInputStreamUse();
	}
}