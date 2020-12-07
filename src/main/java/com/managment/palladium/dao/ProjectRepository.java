package com.managment.palladium.dao;

import com.managment.palladium.dto.ChartData;
import com.managment.palladium.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Override
    public List<Project> findAll();

    Project findByProjectId(long theId);

    @Query(nativeQuery = true, value="SELECT stage as label, COUNT(*) as value " +
            "FROM project " +
            "GROUP by stage")
    public List<ChartData> getProjectStatus();
}
