package edu.ucdavis.afs.dao;


import edu.ucdavis.afs.model.Project;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class ProjectDaoImpl implements ProjectDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Project getProjectById(Long projectId) {
        String jpql = "SELECT p FROM Project p WHERE id = :id";
        TypedQuery<Project> q = entityManager.createQuery(jpql, Project.class);
        q.setParameter("id", projectId);
        try {
            Project project = q.getSingleResult();
            return project;
        } catch (Exception e) {
            return null;
        }
    }
}
