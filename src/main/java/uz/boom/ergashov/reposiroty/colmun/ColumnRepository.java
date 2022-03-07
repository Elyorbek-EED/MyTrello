package uz.boom.ergashov.reposiroty.colmun;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.boom.ergashov.entity.columns.ProjectColumn;
import uz.boom.ergashov.entity.project.Project;
import uz.boom.ergashov.reposiroty.AbstractRepository;

import java.util.List;

@Transactional
@Repository
public interface ColumnRepository extends JpaRepository<ProjectColumn, Long>, AbstractRepository {

    @Query("from ProjectColumn c where c.project_id=:project order by c.position")
    List<ProjectColumn> findAllByProject_id(@Param("project") Project project);
}
