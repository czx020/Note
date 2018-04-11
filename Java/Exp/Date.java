/*
例4-3 功能简介：通过一个日期类熟悉this 的使用。日期包括年、月、日
*/
public class Date{
	private int year;
	private int month;
	private int day;
	public Date (int year,int month ,int day)
	{
		/*当成员方法的参数和成员变量同名时，在方法体中需要使用this引用成员变量，
	this 一般不省略。当无同名成员，this可省略。*/
		this.year = year;
		this.month = month ;
		this.day = day;
	}
	public Date () //无参数的构造方法，重载
	{
		this (2005,8,16); //调用本类已定义的其他构造方法
	}
	public Date (Date oday) //由已存在的对象创建新对象的构造方法
	{
		this(oday.year,oday.month,oday.day);
	}
	public void setYear (int year) // 成员变量赋值
	{
		this.year = year;
}
public int getYear()//获取成员变量的值
{
	return year;
}
public void setMonth (int month) //成员变量赋值
{
	this.month=month;
}
public int getMonth()
{
	return this.month = ((month>=1)&(month<=12))?month:1;
}
public void setDay (int day) //成员变量赋值
{
	this.day =day;
}
public int getDay()
{
	return this.day = ((day>=1)& (day<=31))?day:1;
}
public String toString() //返回年月日的格式
{
	return this.year + "-" + this.month+ "-"+ this.day;//tis指代当前对象
}
public void print ()
{
	System.out.println("date is "+this.toString());
}
}
		