public class CommissionEmployeeTest{
	public static void main (String[]args){
		CommissionEmployee employee = new CommissionEmployee("小李子","010001",1000000,.06);
		System.out.println("员工基本信息如下:\n");
        System.out.printf("%s%s\n","员工姓名",employee.getName());
		System.out.printf("%s%s\n","员工工号",employee.getID());
		System.out.printf("%s%.2f\n","销售额",employee.getGrossSales());
		System.out.printf("%s%.2f\n","提成率",employee.getCommissionRate());
		System.out.printf("%s%.2f\n","员工工资",employee.earnings());
		employee.setGrossSales(500);
		employee.setCommissionRate(.1);
		System.out.printf("\n%s:\n\n%s\n","更新以后的员工信息",employee);
		System.out.printf("%s%.2f\n","员工工资",employee.earnings());
}
}
