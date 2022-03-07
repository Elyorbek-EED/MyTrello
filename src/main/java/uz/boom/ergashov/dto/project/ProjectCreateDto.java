package uz.boom.ergashov.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import uz.boom.ergashov.dto.Dto;
import uz.boom.ergashov.entity.organization.Organization;

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
public class ProjectCreateDto implements Dto {

    private String name;
    private MultipartFile tz;
    private Organization organization;

    public ProjectCreateDto(String name, MultipartFile tz, Organization organization) {
        this.name = name;
        this.tz = tz;
        this.organization = organization;
    }
}
