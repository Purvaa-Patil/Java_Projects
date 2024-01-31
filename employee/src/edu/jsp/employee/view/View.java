package edu.jsp.employee.view;

import java.util.Comparator;
import java.util.Scanner;

import edu.jsp.employee.controller.Controller;
import edu.jsp.employee.model.Employee;
import edu.jsp.employee.model.SortById;
import edu.jsp.employee.model.SortByName;
import edu.jsp.employee.model.SortByPhone;
import edu.jsp.employee.model.SortBySalary;

public class View {
	
			Scanner sc = new Scanner(System.in);
			Controller controller = new Controller();
			boolean loop =true;
	
			public static void main(String[] args) {
		
				View view=new View();
				while (view.loop) 
				{
					view.mainView();
				}
			
			}
			
			public void mainView(){
				System.out.println("----------------------WELCOME----------------------\n"
						+"SELECT OPERATION TO PERFORM\n"
						+"1.SAVE EMPLOYEE\n"
						+"2.GET EMPLOYEE\n"
						+"3.GET ALL EMPLOYEES\n"
						+"4.DELETE EMPLOYEE\n"
						+"5.UPDATE EMPLOYEE\n"
						+"6.EXIT");
				
				int choice=sc.nextInt();
				switch(choice) {
				case 1:{
					saveEmployee();
					break;
				}
				case 2:{
					getEmployee();
					break;
				}
				case 3:{
					getAllEmployees();
					break;
					
				}
				case 4:{
					deleteEmployee();
					break;
				}
				case 5:{
					updateEmployee();
					break;
				}
				case 6:{
					this.loop=false;
					System.out.println("THANK YOU");
					break;
				}
					default:System.out.println("INVALID CHOICE PLEASE TRY AGAIN");
				}
				
			}
			public void saveEmployee() {
				System.out.println("Enter Employee ID:\n");
				int id=sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter Employee Name:\n");
				String name=sc.nextLine();
				sc.nextLine();
				
				System.out.println("Enter Employee Salary:\n");
				double sal=sc.nextDouble();
				sc.nextLine();
				
				System.out.println("Enter Employee Contact:\n");
				long contact=sc.nextLong();
				sc.nextLine();
				
				Employee employee=new Employee(id,name,sal,contact);
				

				if(controller.saveEmployee(employee)!=null) {
					System.out.println("Employee saved\n");
				}
				else {
					System.out.println("Something went wrong.\n");
				}
					
			}
			

			public void getEmployee() {
				System.out.println("Enter User ID:\n");
				int id=sc.nextInt();
				
				Employee employee;
				
				if((employee=controller.getEmployee(id))!=null) {
					System.out.println("Employee Id:"+employee.getId());
					System.out.println("Employee Name:"+employee.getName());
					System.out.println("Employee Salary:"+employee.getSal());
					System.out.println("Employee Contact:"+employee.getPhone());
					
				}
				else {
					System.out.println("Employee not Found\n");
				}
				
			}
			
			public void getAllEmployees() {
				
				if(controller.getAllEmployees().isEmpty()) {
					System.out.println("No Employees are Present.\n");
					return;
				}
				
				sortEmployee()
				
				for(Employee employee: controller.getAllEmployees()) {
					
					System.out.println("Employee Id:"+employee.getId());
					System.out.println("Employee Name:"+employee.getName());
					System.out.println("Employee Salary:"+employee.getSal());
					System.out.println("Employee Contact:"+employee.getPhone());
					
					System.out.println("-----------------------------------------------------------");
				}
			}
			
			public void deleteEmployee() {
				
				getAllEmployees();
				
				System.out.println("Enter Employee ID:\n");
				int id=sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter Employee Name:\n");
				String name=sc.nextLine();
				sc.nextLine();
				
				System.out.println("Enter Employee Salary:\n");
				double sal=sc.nextDouble();
				sc.nextLine();
				
				System.out.println("Enter Employee Contact:\n");
				long contact=sc.nextLong();
				sc.nextLine();				
				Employee employee=new Employee(id,name,sal,contact);
				
				for(Employee employee1 : controller.getAllEmployees()) {
					
					if(employee1.getId()==employee.getId()) {
						
						if(employee1.getName().equalsIgnoreCase(employee.getName())) {
							
							if(employee1.getSal()==employee.getSal()) {
								
								if(employee1.getPhone()==employee.getPhone()) {
									
									controller.deleteEmployee(employee);
									System.out.println("Employee Deleted.\n");
									return;
								}
							}
							
						}
					}
				}
				System.out.println("Employee Not Found.\n");	
			}
			
			public void updateEmployee() {
				getAllEmployees();
				System.out.println("Enter ID:");
				int id=sc.nextInt();
				sc.nextLine();
				
				for(Employee  employee: controller.getAllEmployees()) {
					
					if(employee.getId()==id) {
						Employee  employee1=employee;
						
						System.out.println("ENTER WHAT TO UPDATE\n"
						+"1.ID\n"
						+"2.NAME\n"
						+"3.SALARY\n"
						+"4.CONTACT\n"
						+"5.UPDATE ALL");
				
				int choice=sc.nextInt();
				sc.nextLine();
				
				switch(choice) {
				
				case 1:{
					System.out.println("Enter Employee ID:\n");
					int id1=sc.nextInt();
					employee1.setId(id1);
					System.out.println("EMPLOYEE ID UPDATED.\n");
					
					break;
				}
					
				case 2:{ 
					System.out.println("Enter Employee Name:\n");
					String name=sc.nextLine();
					employee1.setName(name);
					System.out.println("EMPLOYEE NAME UPDATED.\n");
					
					break;
				}
					
				case 3:{
					System.out.println("Enter Employee Salary:\n");
					double sal=sc.nextDouble();
					employee1.setSal(sal);
					System.out.println("EMPLOYEE SALARY UPDATED.\n");
					break;
				}
					
				case 4:{
					System.out.println("Enter Employee Contact:\n");
					long contact=sc.nextLong();
					employee1.setPhone(contact);
					System.out.println("EMPLOYEE CONTACT UPDATED.\n");
					break;
				}
					
				case 5:{ 
					System.out.println("Enter Employee ID:\n");
					int id1=sc.nextInt();
					sc.nextLine();
				
					System.out.println("Enter Employee Name:\n");
					String name=sc.nextLine();
					sc.nextLine();
				
					System.out.println("Enter Employee Salary:\n");
					double sal=sc.nextDouble();
					sc.nextLine();
				
					System.out.println("Enter Employee Contact:\n");
					long contact=sc.nextLong();
					sc.nextLine();
				
				
					employee1.setId(id1);
					employee1.setName(name);
					employee1.setSal(sal);
					employee1.setPhone(contact);
				
					break;
				}	
				
				default:System.out.println("INVALID CHOICE PLEASE TRY AGAIN");
				
				}
				
				System.out.println("EMPLOYEE DETAILS UPDATED.\n");
				
				}
			}
		}
		public void sortEmployee()	{
			System.out.println("Select Sorting Option : \\n"
					+"1.Sort by Id\n"
					+"1.Sort by Name\n"
					+"1.Sort by sal\n"
					+"1.Sort by Phone\n"
					+"1.Sort by Name\n");
			
			
			int sortingChoice=sc.nextInt();
			switch(sortingChoice) {
			
			case 1:
				controller.sortEmployees(new SortById());
			break;
			
			case 2:
				controller.sortEmployees(new SortByName());
			break;
			
			case 3:
				controller.sortEmployees(new SortBySalary());
			break;
			
			case 4:
				controller.sortEmployees(new SortByPhone());
			break;
			
			default:
				System.out.println("Invalid choice ");
				
			}
		}
	}


