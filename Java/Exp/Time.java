public class Time {
	private int hour;  //ȡֵ0~23h
	private int minute; //ȡֵ0~59min
	private int second; //ȡֵ0~59s
	public Time (int h,int m,int s){
		setHour(h);
		setMinute(m);
		setSecond(s);
	}
	public Time (Time time){ //���ع��췽���������Ƕ���
		this(time.getHour(),time.getMinute(),time.getSecond());
	}
	public void setHour(int h){
		hour = ((h>=0 && h<24) ? h:0); //С��Ҫ���ڵ���0С��24
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
	//ͨ��ʱ����ʾ(HH:MM:SS)
	public String tuUniversalString(){
		return String.format("%02d:%02d:%02d",getHour(),getMinute(),getSecond());
	}
	//��׼��ʽʱ����ʾ��H��MM��SS AM or PM��
	public String toString(){
		return String.format("d:%02d:%02d%s",((getHour()==0 || getHour() == 12) ? 12:getHour()%12),getMinute(),getSecond(),(getHour()<12 ? "AM":"PM"));
	}
}