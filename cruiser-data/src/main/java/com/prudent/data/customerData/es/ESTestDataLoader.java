package com.prudent.data.customerData.es;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.prudent.data.customerDB.es.entity.Employee;
import com.prudent.data.customerData.es.repository.EmployeeRepository;

public class ESTestDataLoader {
	public static void main(String[] args) throws Exception{
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ElasticSearchConfig.class);
		EmployeeRepository employeeRepository = appContext.getBean(EmployeeRepository.class);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Employee emp = new Employee();
		emp.setId(1L);
		emp.setBirthday(sdf.parse("1970-12-11"));
		emp.setComments("comment");
		emp.setEmail("employee@gmail.com");
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(emp);
		employeeRepository.save(employees);
		appContext.close();
	}
}
