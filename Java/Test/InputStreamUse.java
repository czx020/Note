/*inputStream类的使用。*/
import java.io.InputStream;
import java.io.IOException;

public class InputStreamUse{
	//结构方法接收输入的数据并将数据输出
	public InputStreamUse(InputStream in){
		try{
			while(true){
				int i = in.read();
				char c = (char)i;
				System.out.print(c);
			}
	}catch(IOException e){
		System.out.print(e);
		e.printStackTrace();
}
}
public static void main (String[]args){
	new InputStreamUse(System.in);
}
}