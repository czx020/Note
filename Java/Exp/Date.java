/*
��4-3 ���ܼ�飺ͨ��һ����������Ϥthis ��ʹ�á����ڰ����ꡢ�¡���
*/
public class Date{
	private int year;
	private int month;
	private int day;
	public Date (int year,int month ,int day)
	{
		/*����Ա�����Ĳ����ͳ�Ա����ͬ��ʱ���ڷ���������Ҫʹ��this���ó�Ա������
	this һ�㲻ʡ�ԡ�����ͬ����Ա��this��ʡ�ԡ�*/
		this.year = year;
		this.month = month ;
		this.day = day;
	}
	public Date () //�޲����Ĺ��췽��������
	{
		this (2005,8,16); //���ñ����Ѷ�����������췽��
	}
	public Date (Date oday) //���Ѵ��ڵĶ��󴴽��¶���Ĺ��췽��
	{
		this(oday.year,oday.month,oday.day);
	}
	public void setYear (int year) // ��Ա������ֵ
	{
		this.year = year;
}
public int getYear()//��ȡ��Ա������ֵ
{
	return year;
}
public void setMonth (int month) //��Ա������ֵ
{
	this.month=month;
}
public int getMonth()
{
	return this.month = ((month>=1)&(month<=12))?month:1;
}
public void setDay (int day) //��Ա������ֵ
{
	this.day =day;
}
public int getDay()
{
	return this.day = ((day>=1)& (day<=31))?day:1;
}
public String toString() //���������յĸ�ʽ
{
	return this.year + "-" + this.month+ "-"+ this.day;//tisָ����ǰ����
}
public void print ()
{
	System.out.println("date is "+this.toString());
}
}
		