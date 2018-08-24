/*对象流的使用*/
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class ObjectStreamUse{
	//向指定的文件写入若干学生对象
	public void writeToFile() throws IOException {
		FileOutputStream fout = new FileOutputStream("E:/学生.txt");
		ObjectOutputStream objout = new ObjectOutputStream(fout);
		//写入对象
		objout.writeObject(new Student("张三丰"));
		objout.writeObject(new Student("金正恩"));
		objout.writeObject(new Student("江泽民"));
		objout.writeObject(new Student("习近平"));
		objout.close();
		fout.close();
	}
	//从制定文件中读取若干学生对象
	public void readFromFile() throws IOException{
		FileInputStream fin = new FileInputStream("E:/学生.txt");
		while(true){
			try{
				// 读取一个对象
				Student stu=(Student)objin.readObject();
				System.out.println(stu.toString()+" ");
			}catch (Exception e){
				e.getMessage();
				break;
			}
		}
		objin.close();
		fin.close();
	}
	//返回从指定的文件中读取的学生对象数组
	public Student[] openFile() throws IOException{
		FileInputStream fin = new FileInputStream("E:/学生.txt");
		ObjectInputStream objin = new ObjectInputStream(fin);
		Student[] students = new Student[20];
		int i = 0;
		while(true){
			try{
			//读取一个对象
			students[i] = (Student) objin.readObject();
			i++;
			}catch (Exception e){
				e.getMessage();
				break;
			}
		}
		objin.close();
		fin.close();
		return students;
	}
	public static void main (String[]args) throws IOException{
		ObjectStreamUse afile = new ObjectStreamUse();
		afile.writeToFile();
		afile.readFromFile();
	}
}