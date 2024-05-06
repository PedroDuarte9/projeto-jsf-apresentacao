package br.com.meuprojeto.service;

import br.com.meuprojeto.entidades.Employee;

public class EmployeeService  {
	
	private Employee employee;
		
	public EmployeeService() {
		
	}
	
	public EmployeeService(Employee employee) {
			this.employee = employee;
	}




	public double calcularSalario() {
		double total = employee.getGrossSalary() * employee.getTax();
		return total;
	}
	
	

}
