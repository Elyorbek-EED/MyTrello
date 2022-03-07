package uz.boom.ergashov.configs.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.boom.ergashov.entity.auth.AuthUser;
import uz.boom.ergashov.reposiroty.auth.AuthUserRepository;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/7/2022
 * @project : mealDeliver
 */

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    private final AuthUserRepository authUserRepository;

    public ApplicationUserDetailsService(AuthUserRepository authUserRepository) {
        this.authUserRepository = authUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser user = authUserRepository.findAuthUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserDetails(user);

//        AuthUser user = authUserRepository.findAuthUserByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User topilmadi");
//        }
//        return User.builder()
//                .username(user.getUsername())
//                .password(user.getPassword())
//                .disabled(!user.isActive())
//                .authorities(new ArrayList<>())
//                .accountLocked(user.isBlocked())
//                .build();
    }
}
