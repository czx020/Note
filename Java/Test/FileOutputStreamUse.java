/*使用FileoutputStream类把数据输出到文件中，即把数据写入文件*/
import java.io.FileOutputStream;
import java.io.IOException;
public class FileOutputStreamUse{
	public FileOutputStreamUse(){
		String s="有志者，事竟成，破釜沉舟，百二秦关终属楚；苦心人天不负，卧薪尝胆。三千越甲可吞吴。";
		byte[] b = s.getBytes();
		try{
			/*实例化一个文件输出流对象其中ｓｔｒｉｎｇ类型参数"座右铭。ｔｘｔ“是文件名，如该文件在
			指定路径下已存在，就覆盖里面的内容。否则在指定位置新建。也可以使用重载的方法FileoutputStream9string name,
			bo0lean append）指定追加方式，实现在文本末尾追加内容*/
			FileOutputStream f = new FileOutputStream("E:/座右铭.txt");
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