package uz.boom.ergashov.dto.organization;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import uz.boom.ergashov.dto.GenericDto;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/7/2022
 * @project : mealDeliver
 */

@Getter
@Setter
public class OrganizationUpdateDto extends GenericDto {
    private String name;
    private MultipartFile logo;
    private String email;
    private String code;
    private String location;
    private Long owner;

    public OrganizationUpdateDto(Long id, String name, MultipartFile logo, String email, String code, String location, Long owner) {
        super(id);
        this.name = name;
        this.logo = logo;
        this.email = email;
        this.code = code;
        this.location = location;
        this.owner = owner;
    }
}
