public class Student {
	private String name;
	private String sex;
	private int sid;		//ѧ��
	public Student (String ����,String �Ա�,int ѧ��)//���幹�취
	{
		name = ����;
		sex = �Ա�;
		sid = ѧ��;
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
	