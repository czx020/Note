/*数据字节流的使用*/
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataStreamUse{
	public DataStreamUse(){
		try{
			FileOutputStream fout = new FileOutputStream("E:/out.txt");
			DataOutputStream dfout = new DataOutputStream(fout);
			for (int i = 0;i<6;i++)
				dfout.writeInt(i);
			dfout.close();
			FileInputStream fin = new FileInputStream("E:/out.txt");
			DataInputStream dfin = new DataInputStream(fin);
			for (int i=0;i<6;i++)
				System.out.print(dfin.readInt()+",");
			dfin.close();
		}catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
	}
	public static void main (String[]args){
		new DataStreamUse();
	}
}