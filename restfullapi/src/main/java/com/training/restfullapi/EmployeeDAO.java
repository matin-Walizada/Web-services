package com.training.restfullapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements ServiceDAO{
	
	private Connection con = null;
	Employee emp;
	
	public EmployeeDAO() {
		this.getConnection();
	}
	@Override
	public Employee getEmployee(int id) {
		String query = "select * from Employee where id = "+id;
		try {
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				emp = new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3));
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		return emp;
	}
	
	@Override
	public List<Employee> getEmployees(){
		List<Employee> emplist = new ArrayList<Employee>();
		
		return emplist;
	}
	
	public void getConnection() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(DBConfig.ULR, DBConfig.USERNAME, DBConfig.PASSWORD);
		}catch(Exception e) {
			System.out.println("Connection error occured" +e);
		}
	}
}
