package uz.boom.ergashov.services.auth;

import org.springframework.stereotype.Service;
import uz.boom.ergashov.entity.auth.AuthRole;
import uz.boom.ergashov.reposiroty.auth.RoleRepository;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/7/2022
 * @project : mealDeliver
 */

@Service
public class RoleService {
    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public Long create(AuthRole role) {
        return repository.save(role).getId();
    }

    public void addPermissions(Long userId, String role, String permissions, Long languageId) {
        repository.addPermissions(userId, role, permissions, languageId);
    }
}
