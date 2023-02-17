package in.cms.springbootcms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import in.cms.springbootcms.exception.ResourceNotFoundException;
import in.cms.springbootcms.model.Employee;
import in.cms.springbootcms.repository.EmployeeRepository;
import in.cms.springbootcms.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) 
	{
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) 
	{
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() 
	{
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) 
	{
		return employeeRepository.findById(id).orElseThrow(() ->
						new ResourceNotFoundException("Employee", "Id", id));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		// We need to check whether employee with given id exist in DB or not
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee","Id", id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setWorkDept(employee.getWorkDept());
		existingEmployee.setHireDate(employee.getHireDate());
		existingEmployee.setSalaryPay(employee.getSalaryPay());


		
		// Save existing employee to DB
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id)
	{
		// Check whether employee exist in DB or not
		employeeRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Employee","Id", id));
		employeeRepository.deleteById(id);
		
	}	
}

















