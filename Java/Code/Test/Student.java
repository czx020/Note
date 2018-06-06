/*序列化对象*/
import java.io.Serializable;
/*Serializable接口是序列化接口，该接口没有方法。实现该接口的类的Student是序列化类。当以
对象为单位读/写数据时，必须将声明为序列化类，以约定每次读/写的字节数，否则不知道该读/写多少字节数*/
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