package com.training.restfullapi;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployees(){
		return employeeImpl.getEmployees();
	}
	
	@POST
	@Path("create")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public void creatEmployee(Employee emp) {
		employeeImpl.creatEmployee(emp);
	}
}
