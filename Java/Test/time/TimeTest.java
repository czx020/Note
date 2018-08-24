package time;
public class TimeTest {
	public static void main(String[]args) {
        Time t1 = new Time(12,25,42 );
        Time t2 = new Time(27,74,99);
        Time t3 = new Time(t1);
		System.out.printf(" %s\n", t1.toUniversalString());
		System.out.printf(" %s\n", t1.toString());
		System.out.printf(" %s\n", t2.toUniversalString());
		System.out.printf(" %s\n", t2.toString());
		System.out.printf(" %s\n", t3.toUniversalString());
		System.out.printf(" %s\n", t3.toString());
	}
}
