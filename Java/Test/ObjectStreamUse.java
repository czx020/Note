/*��������ʹ��*/
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class ObjectStreamUse{
	//��ָ�����ļ�д������ѧ������
	public void writeToFile() throws IOException {
		FileOutputStream fout = new FileOutputStream("E:/ѧ��.txt");
		ObjectOutputStream objout = new ObjectOutputStream(fout);
		//д�����
		objout.writeObject(new Student("������"));
		objout.writeObject(new Student("������"));
		objout.writeObject(new Student("������"));
		objout.writeObject(new Student("ϰ��ƽ"));
		objout.close();
		fout.close();
	}
	//���ƶ��ļ��ж�ȡ����ѧ������
	public void readFromFile() throws IOException{
		FileInputStream fin = new FileInputStream("E:/ѧ��.txt");
		while(true){
			try{
				// ��ȡһ������
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
	//���ش�ָ�����ļ��ж�ȡ��ѧ����������
	public Student[] openFile() throws IOException{
		FileInputStream fin = new FileInputStream("E:/ѧ��.txt");
		ObjectInputStream objin = new ObjectInputStream(fin);
		Student[] students = new Student[20];
		int i = 0;
		while(true){
			try{
			//��ȡһ������
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