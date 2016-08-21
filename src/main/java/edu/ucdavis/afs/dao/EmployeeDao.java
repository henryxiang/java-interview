package edu.ucdavis.afs.dao;

import edu.ucdavis.afs.model.Employee;

import java.util.List;

/**
 * Data access object interface to handle Employee related information
 */
public interface EmployeeDao {
    /**
     * This method is used to retrieve the employee information from the database by specifying employee ID.
     * @param employeeId Employee ID
     * @return Employee An Employee object with detailed information including project assignments, or null if employee not found.
     */
    Employee getEmployeeById(Long employeeId);

    /**
     * This method is used to search for employees with certain search criteria specified by passed in parameters.
     * @param firstName (Optional) If provided, it'll be used as a query keyword to partially match employee's first name.
     * @param lastName  (Optional) If provided, it'll be used as a query keyword to partially match employee's last name.
     * @param jobTitle  (Optional) If provided, it'll be used as a query keyword to partially match employee's job title.
     * @return List<Employee> A list of employees that match the search criteria, or a empty list if no employee is found.
     */
    List<Employee> findEmployees(String firstName, String lastName, String jobTitle);

    /**
     * This method is used to persist the employee information to backend database.
     * @param employee An employee object containing the updated information that needs to be saved.
     * @return Long Employee ID if the transaction succeeds, or null if the transaction fails.
     */
    Long saveEmployee(Employee employee);
}
