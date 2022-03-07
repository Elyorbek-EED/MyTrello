package uz.boom.ergashov.dto.auth;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import uz.boom.ergashov.dto.Dto;

import java.util.List;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/7/2022
 * @project : mealDeliver
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserCreateDto implements Dto {

    private String username;
    private String password;
    private String email;
    private MultipartFile profileImage;
    private boolean superUser;
    private List<Long> permissions;
    private String role;
    private Long language;

}
