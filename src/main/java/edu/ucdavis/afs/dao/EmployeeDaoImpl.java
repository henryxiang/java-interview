package edu.ucdavis.afs.dao;

import edu.ucdavis.afs.model.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    @Transactional
    public Employee getEmployeeById(Long employeeId) {
        // TODO: implement this method per requirements
        return null;
    }

    @Override
    @Transactional
    public List<Employee> findEmployees(String firstName, String lastName, String jobTitle) {
        // TODO: implement this method per requirements
        return null;
    }

    @Override
    @Transactional
    public Long saveEmployee(Employee employee) {
        // TODO: implement this method per requirements
        return null;
    }
}
