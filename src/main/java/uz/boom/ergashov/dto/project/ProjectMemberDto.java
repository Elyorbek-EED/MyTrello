package uz.boom.ergashov.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.boom.ergashov.dto.GenericDto;
import uz.boom.ergashov.entity.auth.AuthUser;
import uz.boom.ergashov.entity.project.Project;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/7/2022
 * @project : mealDeliver
 */
@Getter
@Setter
public class ProjectMemberDto extends GenericDto {
    private Project project;

    private AuthUser authUser;

    private Boolean isLead;

    @Builder(builderMethodName = "childBuilder")
    public ProjectMemberDto(Long id, Project project, AuthUser authUser, Boolean isLead) {
        super(id);
        this.project = project;
        this.authUser = authUser;
        this.isLead = isLead;
    }
}
