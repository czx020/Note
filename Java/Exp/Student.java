public class Student {
	private String name;
	private String sex;
	private int sid;		//学号
	public Student (String 姓名,String 性别,int 学号)//定义构造法
	{
		name = 姓名;
		sex = 性别;
		sid = 学号;
	}
	public String getName(){
		return name;
	}
	public void setName (String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex){
		this.sex = sex;
	}
	public int getSid (){
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
		}
}
	