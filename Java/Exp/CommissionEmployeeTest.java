public class CommissionEmployeeTest{
	public static void main (String[]args){
		CommissionEmployeeommissionEmployee employee =new CommissionEmployee ("С����","010001",1000000,0.6);
		System.out.println("Ա�������������:\n");
		System,out.printf("%S%s\n"��"Ա������",employee.getID());
		System.our.printf("%s%.2f\n","���۶�",employee.getGrossSales());
		System.our.printf("%s%.2f\n","�����",employee.getCommissionRate());
		System.our.printf("%s%.2f\n","Ա������",employee.earnings());
		employee.setGrossSales(500);
		employee.setCommissionRate(.1);
		System.our.printf("\n%s:\n\n%s\n","�����Ժ��Ա����Ϣ",employee);
		System.our.printf("%s%.2f\n","Ա������",employee.earnings());
}
}