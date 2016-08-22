package edu.ucdavis.afs.controller;

import edu.ucdavis.afs.dao.EmployeeDao;
import edu.ucdavis.afs.dao.ProjectDao;
import edu.ucdavis.afs.model.Employee;
import edu.ucdavis.afs.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class EmployeeRestController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private ProjectDao projectDao;

    @Transactional
    @RequestMapping(value = "/api/employee/{id}", method = RequestMethod.GET)
    public @ResponseBody Employee showEmployeeDetail(
        @PathVariable Long id,
        HttpServletResponse response)
    {
        Employee employee = employeeDao.getEmployeeById(id);
        Project project = projectDao.getProjectById(1L);
        if (employee != null) {
            //employee.addProject(project);
            return employee;
        }
        else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return null;
        }
    }

    @Transactional
    @RequestMapping(value = "/api/employee", method = RequestMethod.GET)
    public @ResponseBody List<Employee> searchEmployees(
        @RequestParam(value = "firstname", required = false) String firstName,
        @RequestParam(value = "lastname", required = false) String lastName,
        @RequestParam(value = "title", required = false) String jobTitle,
        HttpServletResponse response)
    {
        // TODO: implement this method per requirements
        return null;
    }

    @Transactional
    @RequestMapping(value = "/api/employee", method = RequestMethod.POST)
    public @ResponseBody String saveEmployee(
        @RequestBody Employee employee,
        HttpServletResponse response)
    {
        // TODO: implement this method per requirements
        return null;
    }
}
