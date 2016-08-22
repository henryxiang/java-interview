package edu.ucdavis.afs.dao;


import edu.ucdavis.afs.model.Project;

public interface ProjectDao {
    Project getProjectById(Long projectId);
}
