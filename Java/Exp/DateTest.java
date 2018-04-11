/*
例4-4
*/
public class DateTest {
	public static void main (String[]args){
		Date oday1=new Date(); //默认参数的构造方法
		Date oday2=new Date(2005,8,16);//指定参数的构造方法
		Date oday3=new Date(oday2);//由已知对象创建新对象的构造方法
		oday1.print();
		oday2.print();
		oday3.print();
}
}