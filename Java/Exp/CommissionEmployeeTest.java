public class CommissionEmployeeTest{
	public static void main (String[]args){
		CommissionEmployeeommissionEmployee employee =new CommissionEmployee ("小李子","010001",1000000,0.6);
		System.out.println("员工基本情况如下:\n");
		System,out.printf("%S%s\n"，"员工工号",employee.getID());
		System.our.printf("%s%.2f\n","销售额",employee.getGrossSales());
		System.our.printf("%s%.2f\n","提成率",employee.getCommissionRate());
		System.our.printf("%s%.2f\n","员工工资",employee.earnings());
		employee.setGrossSales(500);
		employee.setCommissionRate(.1);
		System.our.printf("\n%s:\n\n%s\n","更新以后的员工信息",employee);
		System.our.printf("%s%.2f\n","员工工资",employee.earnings());
}
}