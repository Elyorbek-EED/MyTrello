package uz.boom.ergashov.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.boom.ergashov.dto.GenericDto;
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

public class ProjectDto extends GenericDto {

    private String name;
    private String tzPath;
    private Organization organization;
    private Boolean closed;

    @Builder(builderMethodName = "childBuilder")
    public ProjectDto(Long id, String name, String tzPath, Organization organization, Boolean closed) {
        super(id);
        this.name = name;
        this.tzPath = tzPath;
        this.organization = organization;
        this.closed = closed;
    }
}
