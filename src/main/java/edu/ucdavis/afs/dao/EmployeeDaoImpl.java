package edu.ucdavis.afs.dao;

import edu.ucdavis.afs.model.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    @Override
    @Transactional
    public Employee getEmployeeById(Long employeeId) {
        String jpql = "SELECT e FROM Employee e WHERE e.id = :id";
        TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
        query.setParameter("id", employeeId);
        try {
            return query.getSingleResult();
        }
        catch (Exception e) {
            return null;
        }
    }

    @Override
    @Transactional
    public List<Employee> findEmployees(String firstName, String lastName, String jobTitle) {
        List<Employee> employees = new ArrayList<>();
        if (!(StringUtils.isEmpty(firstName) && StringUtils.isEmpty(lastName) && StringUtils.isEmpty(jobTitle))) {
            CriteriaBuilder qb = entityManager.getCriteriaBuilder();
            CriteriaQuery cq = qb.createQuery();
            Root<Employee> employeeRoot = cq.from(Employee.class);
            List<Predicate> predicates = new ArrayList<>();
            if (!StringUtils.isEmpty(firstName)) {
                predicates.add(qb.like(qb.lower(employeeRoot.<String>get("firstName")), firstName.toLowerCase() + "%"));
            }
            if (!StringUtils.isEmpty(lastName)) {
                predicates.add(qb.like(qb.lower(employeeRoot.<String>get("lastName")), lastName.toLowerCase() + "%"));
            }
            if (!StringUtils.isEmpty(jobTitle)) {
                predicates.add(qb.like(qb.lower(employeeRoot.<String>get("jobTitle")), "%" + jobTitle.toLowerCase() + "%"));
            }
            cq.select(employeeRoot).where(qb.and(predicates.toArray(new Predicate[predicates.size()])));
            employees = entityManager.createQuery(cq).getResultList();
        }
        return employees;
    }

    @Override
    @Transactional
    public Long saveEmployee(Employee employee) {
        if (employee.getId() == null) {
            entityManager.persist(employee);
            return employee.getId();
        }
        else {
            Employee e = this.getEmployeeById(employee.getId());
            if (e.getId() == null) {
                return null;
            }
            else {
                employee.copyEmployee(e);
                return e.getId();
            }
        }
    }
}
