package com.managment.palladium.dao;

import com.managment.palladium.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    public Project findByProjectId(long theId);
}
