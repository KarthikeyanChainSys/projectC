package com.chainsys.application.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.application.employee.Employee;
import com.chainsys.application.employee.EmployeeDao;

@RestController
public class Service {
	@RequestMapping("/getEmployee")
	public String getData(@RequestParam(name = "id") String id) {
		int empId = Integer.parseInt(id);
		Employee emp = EmployeeDao.getEmployeeById(empId);
		return emp.getFirst_name() + ", " + emp.getLast_name() + ", " + emp.getJob_id() + ", " + emp.getSalary() + ", "
				+ emp.getHire_date() + ", " + emp.getEmail();
	}

	@RequestMapping("/getAll")
	public String getAll() {
		List<Employee> allEmployees = EmployeeDao.getAllEmployees();
		Iterator<Employee> empIterator = allEmployees.iterator();
		String result = "";
		while (empIterator.hasNext()) {
			Employee emp = empIterator.next();
			result += "<div>" + emp.getFirst_name() + ", " + emp.getLast_name() + ", " + emp.getJob_id() + ", "
					+ emp.getSalary() + ", " + emp.getHire_date() + ", " + emp.getEmail();
		}
		return result;
	}

	@RequestMapping(value = "/newEmployee", method = RequestMethod.POST)
	public int addNewEmployee() {
		return 0;
	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT)
	public int modifyEmployee() {
		return 1;
	}

	@RequestMapping(value = "/removeEmployee", method = RequestMethod.DELETE)
	public int deleteEmployee() {
		return 2;
	}
}
