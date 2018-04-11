/*使用java类库的静态方法以及自定义的静态方法，熟悉静态方法的使用
*/
public class StatingTest{
	//main()方法是静态方法，静态方法无须实例化对象就可以直接使用
	public static void main (String []args){
		/*调用math类的round（）静态方法，其功能是对参数值进行四舍五入处理，并将处理的结果返回*/
		System.out.println(Math.round(2.56));
		String s = toChar(5.678);//调用StaticTest类中定义的toChar（）静态方法
		System.out.println("e="+s);
	}
	public static String  toChar (double x) //声明静态方法
	{
		/*调用double类中的toString（）静态方发，其功能是将double类型的参数值转为String类型并返回*/
		return Double.toString(x);
	}
}