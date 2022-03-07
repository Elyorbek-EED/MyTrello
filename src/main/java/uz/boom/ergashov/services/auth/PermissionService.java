package uz.boom.ergashov.services.auth;

import org.springframework.stereotype.Service;
import uz.boom.ergashov.entity.auth.AuthPermission;
import uz.boom.ergashov.reposiroty.auth.PermissionRepository;

import java.util.List;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/7/2022
 * @project : mealDeliver
 */

@Service
public class PermissionService {

    private final PermissionRepository repository;

    public PermissionService(PermissionRepository repository) {
        this.repository = repository;
    }

    public List<AuthPermission> getAll() {
        return repository.findAll();
    }
}
