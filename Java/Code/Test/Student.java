/*���л�����*/
import java.io.Serializable;
/*Serializable�ӿ������л��ӿڣ��ýӿ�û�з�����ʵ�ָýӿڵ����Student�����л��ࡣ����
����Ϊ��λ��/д����ʱ�����뽫����Ϊ���л��࣬��Լ��ÿ�ζ�/д���ֽ���������֪���ö�/д�����ֽ���*/
public class Student implements Serializable{
	private int number;
	private String name;
	private static int count=0;
	public Student(String  name){
		this.count++;
		this.number = this.count;
		this.name = name;
	}
	public String toString(){
		return this.number+" "+this.name;
	}
}