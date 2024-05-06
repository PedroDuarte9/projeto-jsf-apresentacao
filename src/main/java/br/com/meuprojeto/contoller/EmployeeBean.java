package br.com.meuprojeto.contoller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import br.com.meuprojeto.dao.DaoGeneric;
import br.com.meuprojeto.entidades.Employee;
import br.com.meuprojeto.entidades.Pessoa;
import br.com.meuprojeto.service.EmployeeService;

@ManagedBean(name ="employeeControl")
@SessionScoped
public class EmployeeBean {
	
	private Employee employee = new Employee();
	private List<Employee> listEmployees = new ArrayList<Employee>();
	private EmployeeService employeeService = new EmployeeService();
	private DaoGeneric<Employee> daoGeneric = new DaoGeneric<>();
	
	
	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



	public List<Employee> getListEmployees() {
		return listEmployees;
	}



	public void setListEmployees(List<Employee> listEmployees) {
		this.listEmployees = listEmployees;
	}



	public EmployeeService getEmployeeService() {
		return employeeService;
	}



	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}



	public void enviar() {
		daoGeneric.salvarTemp(employee);
		listEmployees.add(employee);
		
	}
	
	public void calcularImposto() {
		employeeService.calcularSalario();
	}
	
	public void listaTodos(){
		listEmployees.add(employee);
		for (Employee employee : listEmployees) {
			System.out.println(employee.getNameEmployee());
		}
	}

}
