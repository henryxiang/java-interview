package edu.ucdavis.afs;

import edu.ucdavis.afs.dao.ProjectDao;
import edu.ucdavis.afs.model.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProjectDaoTest {
    @Autowired
    private ProjectDao projectDao;

    @Test
    @Transactional
    public void testGetProjectById() {
        Long projectId = 1L;
        String projectName = "Project 1";
        Project project = projectDao.getProjectById(projectId);
        assertEquals("Project id not match", projectId, project.getId());
        assertEquals("Project name not match", projectName, project.getProjectName());
    }
}
