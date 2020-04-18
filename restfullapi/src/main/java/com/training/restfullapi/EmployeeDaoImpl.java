package com.training.restfullapi;

import java.util.List;

public class EmployeeDaoImpl implements ServiceDAO<Employee> {
	
	EmployeeDAO employeeDao = new EmployeeDAO();
	@Override
	public Employee getEmployee(int id) {
		return employeeDao.getEmployee(id);
	}

	@Override
	public  List<Employee> getEmployees() {
		return employeeDao.getEmployees();
	}

	@Override
	public void creatEmployee(Employee emp) {
		// TODO Auto-generated method stub
		employeeDao.creatEmployee(emp);
	}

}
