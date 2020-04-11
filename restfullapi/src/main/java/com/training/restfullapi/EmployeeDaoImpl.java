package com.training.restfullapi;

import java.util.List;

public class EmployeeDaoImpl implements ServiceDAO {
	
	EmployeeDAO employeeDao = new EmployeeDAO();
	@Override
	public Employee getEmployee(int id) {
		return employeeDao.getEmployee(id);
	}

	@Override
	public  List<Employee> getEmployees() {

		return null;
	}

}
