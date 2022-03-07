package uz.boom.ergashov.reposiroty.file;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.boom.ergashov.entity.file.Resource;
import uz.boom.ergashov.reposiroty.AbstractRepository;

/**
 * @author D4uranbek ср. 10:52. 23.02.2022
 */


public interface ResourceRepository extends JpaRepository<Resource, Long>, AbstractRepository {
}
