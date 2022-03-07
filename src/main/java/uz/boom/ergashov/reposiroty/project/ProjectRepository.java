package uz.boom.ergashov.reposiroty.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uz.boom.ergashov.entity.organization.Organization;
import uz.boom.ergashov.entity.project.Project;
import uz.boom.ergashov.reposiroty.AbstractRepository;

import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 17.02.2022 0:32
 * Project : library_boom
 */
@Transactional
public interface ProjectRepository extends JpaRepository<Project,Long>, AbstractRepository {
    Project findProjectById(Long id);

    @Query("from Project p where p.organization_id=:org")
    List<Project> findAllByOrganization_id(
            @Param("org") Organization organization);
}
