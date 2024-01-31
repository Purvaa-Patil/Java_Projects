package edu.jsp.employee.model;

import java.util.Comparator;

public class SortByPhone implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return (int) (o1.getPhone()-o2.getPhone());
	}

}
