/*��4-6
��װ�����۶���ɵ�Ա��������Ϣ
*/
public class CommissionEmployee{
	private String name;
	private String ID;
	private double grossSales;//���۶�
	private double commissionRate;//�����
	public CommissionEmployee(String name, String ID,double sales,double rate){
		this.name=name;
		this.ID=ID;
		setGrossSales(sales);
		setcommissionRate(rate);
	}
	public void setName (String name){
		this.name=name;
	}
	public String getName (){
		return name;
	}
	public void setID (String ID){
		this.ID=ID;
	}
	public String getID () {
		return ID;
	}
	public void setGrossSales (double sales){
		grossSales = sales<0.0)?0.0:sales;
	}
	public double getGrossSales(){
		return grossSales;
	}
	public void setCommissionRate(double rate){
		commissionRate = (rate>0.0&&rate<1.0)?rate:0.0;
	}
	public double getCommissionRate(){
		return commissionRate;
	}
	public double earning (0{
		return commissionRate*grossSales;
	}
	public String toString(){
		return String.format("%s:%s\n%s:%s\n%s:%.2f\n%s:%.2f","Ա������",name,"Ա������",ID,"���۶�",grossSales,"�����",commissionRate);
	}
}