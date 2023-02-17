package in.cms.springbootcms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;     // Use lombok library to reduce boilerplate code: getters/setters/constructors/etc.

@Data        // Generate getters for all fields
@Entity      // This tells Hibernate to make a table out of this class
@Table(name = "employees")        // Name table 'employees'
public class Employee 
{
	@Id                 //Sets primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)   // Specifies the generation strategies for the values of primary keys
	private long id;
	
	// Define columns
	@Column(name = "first_name", nullable = false)    //Set column as not null 
	private String firstName;      //JPA Annotations
	
	@Column(name = "last_name")
	private String lastName;       //JPA Annotations
	
	@Column(name = "email")
	private String email;          //JPA Annotations
	
	@Column(name = "work_dept")
	private String workDept;          //JPA Annotations
	
	@Column(name = "hire_date")
	private String hireDate;          //JPA Annotations
	
	@Column(name = "sex_gender")
	private String gender;          //JPA Annotations
	
	@Column(name = "salary")
	private String salaryPay;          //JPA Annotations
}
