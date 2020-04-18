package com.training.restfullapi;

import java.util.List;

public interface ServiceDAO<T> {
	  T getEmployee(int id);
	  List<T> getEmployees();
	  void creatEmployee(T t);
}
