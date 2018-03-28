public class Time {
	private int hour;  //取值0~23h
	private int minute; //取值0~59min
	private int second; //取值0~59s
	public Time (int h,int m,int s){
		setHour(h);
		setMinute(m);
		setSecond(s);
	}
	public Time (Time time){ //重载构造方法，参数是对象
		this(time.getHour(),time.getMinute(),time.getSecond());
	}
	public void setHour(int h){
		hour = ((h>=0 && h<24) ? h:0); //小数要大于等于0小于24
	}
	public int getHour(){
		return hour;
	}
	public void setMinute(int m){
		minute =((m>=0 && m<=60) ? m:0);
	}
	public int getMinute(){
		return minute;
	}
	public void setSecond(int s){
		second = ((s>=0 && s<60) ? second:0);
	}
	public int getSecond(){
		return second;
	}
	//通用时间显示(HH:MM:SS)
	public String tuUniversalString(){
		return String.format("%02d:%02d:%02d",getHour(),getMinute(),getSecond());
	}
	//标准格式时间显示（H：MM：SS AM or PM）
	public String toString(){
		return String.format("d:%02d:%02d%s",((getHour()==0 || getHour() == 12) ? 12:getHour()%12),getMinute(),getSecond(),(getHour()<12 ? "AM":"PM"));
	}
}