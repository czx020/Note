/*ʹ��java���ľ�̬�����Լ��Զ���ľ�̬��������Ϥ��̬������ʹ��
*/
public class StatingTest{
	//main()�����Ǿ�̬��������̬��������ʵ��������Ϳ���ֱ��ʹ��
	public static void main (String []args){
		/*����math���round������̬�������书���ǶԲ���ֵ�����������봦����������Ľ������*/
		System.out.println(Math.round(2.56));
		String s = toChar(5.678);//����StaticTest���ж����toChar������̬����
		System.out.println("e="+s);
	}
	public static String  toChar (double x) //������̬����
	{
		/*����double���е�toString������̬�������书���ǽ�double���͵Ĳ���ֵתΪString���Ͳ�����*/
		return Double.toString(x);
	}
}