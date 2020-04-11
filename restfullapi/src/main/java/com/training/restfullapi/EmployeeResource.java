package com.training.restfullapi;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("employees")
public class EmployeeResource {
	EmployeeDaoImpl employeeImpl = new EmployeeDaoImpl();
	
	@GET
	@Path("emp/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Employee getEmployee(@PathParam("id") int id) {
		return employeeImpl.getEmployee(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Employee> getEmployees(){
		return employeeImpl.getEmployees();
	}
}
