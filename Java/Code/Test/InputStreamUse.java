/*inputStream���ʹ�á�*/
import java.io.InputStream;
import java.io.IOException;

public class InputStreamUse{
	//�ṹ����������������ݲ����������
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