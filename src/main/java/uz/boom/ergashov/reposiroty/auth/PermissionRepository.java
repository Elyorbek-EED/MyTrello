package uz.boom.ergashov.reposiroty.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.boom.ergashov.entity.auth.AuthPermission;

/**
 * @author D4uranbek чт. 0:09. 24.02.2022
 */
public interface PermissionRepository extends JpaRepository<AuthPermission, Long> {
}
