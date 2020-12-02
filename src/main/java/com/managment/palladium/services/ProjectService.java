package com.managment.palladium.services;

import com.managment.palladium.dao.ProjectRepository;
import com.managment.palladium.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository proRepo;

    public Project save(Project project){
        return proRepo.save(project);
    }

    public Iterable<Project> getAll() {
        return proRepo.findAll();
    }

    public Project findByProjectId(long theId){
        return proRepo.findByProjectId(theId);
    }

    public void delete(Project thePro){
        proRepo.delete(thePro);
    }
}
