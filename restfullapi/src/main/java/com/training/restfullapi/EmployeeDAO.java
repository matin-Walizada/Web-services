package com.training.restfullapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements ServiceDAO<Employee>{
	
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
			if(rs.next()) {
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
		String query = "select * from Employee";
		try {
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				emp = new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3));
				emplist.add(emp);
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		return emplist;
	}
	//excuteQuery
	//execute
	//executeUpdate
	@Override
	public void creatEmployee(Employee emp) { // id, name , salary
		String query = "insert into Employee (id, name, salary) values(?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, emp.getId());
			pst.setString(2, emp.getName());
			pst.setInt(3, emp.getSalary());
			pst.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e);
		}
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
