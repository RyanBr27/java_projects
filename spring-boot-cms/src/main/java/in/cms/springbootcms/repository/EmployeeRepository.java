package in.cms.springbootcms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cms.springbootcms.model.Employee;

// JPA Repository internally provides @Repository Annotation
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{

}
