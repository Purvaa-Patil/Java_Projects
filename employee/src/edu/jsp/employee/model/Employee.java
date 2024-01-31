package edu.jsp.employee.model;

public class Employee {

	private int id; 
	private String name;
	private double sal;
	private long phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public Employee(int id, String name, double sal, long phone) {
		super();
		this.id = id;
		this.name = name;
		this.sal = sal;
		this.phone = phone;
	}
	public Employee() {
		super();
	}
	
}
