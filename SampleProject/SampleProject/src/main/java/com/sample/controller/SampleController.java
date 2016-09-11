package com.sample.controller;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.domain.Employee;
import com.sample.repo.EmployeeRepository;

@ComponentScan("com.sample")
@RestController
@RequestMapping(value="ctrl")
@EntityScan("com.sample")
public class SampleController {	
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	Validator validator;
	
	@RequestMapping(value="getdata",method=RequestMethod.GET)
	private @ResponseBody Employee getdata(@RequestParam(value="name") String name){
		Employee employeesList= employeeRepository.findByName("vinayak");
		if(employeesList !=null){
			return employeesList;
		}else{
			return null;
		}
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST,headers = {"Content-type=application/json"})
	private void save(@RequestBody Employee emp){
		if(emp !=null){
			employeeRepository.save(emp);
		}
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST,headers = {"Content-type=application/json"})
	private void updateEmployee(@RequestBody Employee emp) throws IllegalArgumentException{
		if(emp !=null){
			Employee empList = employeeRepository.findByEmpId(emp.getEmpId());
			if(empList==null){
				throw new IllegalArgumentException("Employee with id "+emp.getEmpId()+" Does not exist!");
			}else{
			employeeRepository.save(emp);
			}
		}
	}
	
	@RequestMapping(value="delete",method=RequestMethod.GET)
	private String delete(@RequestParam(value="empId") String emp){
		Employee employeesList= employeeRepository.findByEmpId(emp);		
		if(employeesList !=null){
			employeeRepository.delete(emp);
			return "SUCCESS"; 
		}else{
			return "Employee with Id "+ emp+" NOT Exist";
		}
	}
	
	
	
}
