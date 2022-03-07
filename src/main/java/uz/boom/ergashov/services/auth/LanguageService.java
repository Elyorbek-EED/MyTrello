package uz.boom.ergashov.services.auth;

import org.springframework.stereotype.Service;
import uz.boom.ergashov.entity.auth.Language;
import uz.boom.ergashov.reposiroty.auth.LanguageRepository;

import java.util.List;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/7/2022
 * @project : mealDeliver
 */

@Service
public class LanguageService {

    private final LanguageRepository repository;

    public LanguageService(LanguageRepository repository) {
        this.repository = repository;
    }

    public List<Language> getAll() {
        return repository.findAll();
    }
}
