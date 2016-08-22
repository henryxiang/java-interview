package edu.ucdavis.afs;

import edu.ucdavis.afs.dao.EmployeeDao;
import edu.ucdavis.afs.dao.ProjectDao;
import edu.ucdavis.afs.model.Employee;
import edu.ucdavis.afs.model.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeDaoTest {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private ProjectDao projectDao;

    @Test
    @Transactional
    public void testGetEmployeeById() {
        Employee employee = employeeDao.getEmployeeById(1L);
        Long expectedEmployeeId = 1L;
        assertNotNull("employee object is null", employee);
        assertEquals("employee ID mismatch", expectedEmployeeId, employee.getId());
    }

    @Test
    @Transactional
    public void testFindEmployees() {
        List<Employee> emp1 = employeeDao.findEmployees("", "", "");
        assertEquals("Employee list should be empty", 0, emp1.size());

        String name = "s";
        List<Employee> emp2 = employeeDao.findEmployees(name, null, null);
        Employee found = null;
        for (Employee e : emp2) {
            if(e.getFirstName().toLowerCase().indexOf(name.toLowerCase()) == 0) {
                found = e;
                break;
            }
        }
        assertNotNull("No employee found by name", found);

        String title = "engineer";
        List<Employee> emp3 = employeeDao.findEmployees(null, null, title);
        found = null;
        for (Employee e : emp3) {
            if(e.getJobTitle().toLowerCase().indexOf(title.toLowerCase()) >= 0) {
                found = e;
                break;
            }
        }
        assertNotNull("No employee found by job title", found);
    }

    @Test
    @Transactional
    public void testSaveNewEmployee() {
        Employee emp1 = new Employee();
        String dummy = "zzzzz";
        emp1.setFirstName(dummy);
        emp1.setLastName(dummy);
        emp1.setJobTitle(dummy);
        emp1.setHiredDate(new Date());
        Long id1 = employeeDao.saveEmployee(emp1);
        List<Employee> ee = employeeDao.findEmployees(dummy, dummy, dummy);
        assertEquals("Employee not saved", 1, ee.size());
        assertEquals("Employee ID not match", id1, ee.get(0).getId());
    }

    @Test
    @Transactional
    public void testSaveExistingEmployee() {
        Employee emp1 = new Employee();
        String dummy = "zzzzz";
        emp1.setId(1L);
        emp1.setPhone(dummy);
        emp1.setJobTitle(dummy);
        Long id1 = employeeDao.saveEmployee(emp1);
        Employee e = employeeDao.getEmployeeById(id1);
        assertEquals("Employee not saved", new Long(1), id1);
        assertEquals("Employee phone not match", dummy, e.getPhone());
        assertEquals("Employee job title not match", dummy, e.getJobTitle());
    }

    @Test
    @Transactional
    public void testSaveEmployeeWithProjects() {
        Long id = 1L;
        assertEquals("Employee should have not project assignments", 0, employeeDao.getEmployeeById(id).getProjects().size());

        Project project1 = projectDao.getProjectById(1L);
        Project project2 = projectDao.getProjectById(2L);
        List<Project> projects = new ArrayList<>();
        projects.add(project1);
        projects.add(project2);
        Employee emp1 = new Employee();
        emp1.setId(1L);
        emp1.setProjects(projects);

        Long id1 = employeeDao.saveEmployee(emp1);
        Employee e = employeeDao.getEmployeeById(id1);
        assertEquals("Employee not saved", new Long(1), id1);
        assertEquals("Project size not match", 2, e.getProjects().size());
        assertEquals("Project name not match", project1.getProjectName(), e.getProjects().get(0).getProjectName());
        assertEquals("Project name not match", project2.getProjectName(), e.getProjects().get(1).getProjectName());
    }
}
