/*使用ＯｕｔｐｕｔＳｔｒｅａｍ类在控制台输出数据*/
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamUse{
	public OutputStreamUse(OutputStream out){
		String s = "慈母手中线，游子身上衣。临行密密缝，意恐迟迟归。谁言寸草心，报得三春晖.";
		byte[] b = s.getBytes();
		try{
			// 将字节数组ｂ写出到输出流
			out.write(b);
			//把缓存的所有内容强制输出
			out.flush();
		}catch (IOException e){
			System.err.print(e);
		}
	}
	public static void main (String[]args){
		new OutputStreamUse(System.out);
	}
}