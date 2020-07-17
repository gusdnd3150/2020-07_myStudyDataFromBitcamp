package class22;
import java.util.Scanner;


interface EmployeeType {
	public int getAmount();
	
}
 class Engineer implements EmployeeType{
	public int getAmount(EmployeeType type){
		return 100;
	}
	
}

 class Manager implements EmployeeType{
	 public int getAmount(EmployeeType type){
			return 200;
	
}

 class Salesman implements EmployeeType{
	 public int getAmount(EmployeeType type){
			return 300;
}


public class Employee2 {
		private EmployeeType type;
		
		public Employee2(EmployeeType type) {
			setType(type);
		}
		public void setType(EmployeeType type) {
			this.type = type;
		}

		@Override
		public String toString() {
			return String.format("%s",type);
		}
		
		public static void main(String[]args) {
			Engineer e= new Engineer();
			Employee2 emp = new Employee2();
			emp.toString();
		}
		
}


