package br.com.meuprojeto.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;

import br.com.meuprojeto.service.EmployeeService;


public class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String nameEmployee;
	
	private Double grossSalary;
	
	private Double tax;
	
		
	private EmployeeService employeeService;
	
	public Employee() {
		
	}
	
	public Employee(String nameEmployee, Double grossSalary, Double tax) {
		this.nameEmployee = nameEmployee;
		this.grossSalary = grossSalary;
		this.tax = tax;
		this.employeeService = new EmployeeService(this);
	}

	public Employee(Long id, String nameEmployee, Double grossSalary, Double tax) {
		super();
		this.id = id;
		this.nameEmployee = nameEmployee;
		this.grossSalary = grossSalary;
		this.tax = tax;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameEmployee() {
		return nameEmployee;
	}

	public void setNameEmployee(String nameEmployee) {
		this.nameEmployee = nameEmployee;
	}

	public Double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(Double grossSalary) {
		this.grossSalary = grossSalary;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}
	

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(id, other.id);
	}
	
}
