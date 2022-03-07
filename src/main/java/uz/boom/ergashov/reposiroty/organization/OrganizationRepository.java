package uz.boom.ergashov.reposiroty.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.boom.ergashov.entity.organization.Organization;
import uz.boom.ergashov.reposiroty.AbstractRepository;

import javax.transaction.Transactional;

@Transactional
public interface OrganizationRepository extends JpaRepository<Organization, Long>, AbstractRepository {
    @Modifying
    @Query(value = "update Organization o set o.blocked = true where o.id = :id")
    void block(@Param("id") Long id);

    @Modifying
    @Query(value = "update Organization o set o.blocked = false where o.id = :id")
    void unblock(@Param("id") Long id);

}
