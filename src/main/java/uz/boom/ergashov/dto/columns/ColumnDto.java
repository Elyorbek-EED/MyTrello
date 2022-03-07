package uz.boom.ergashov.dto.columns;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.boom.ergashov.dto.GenericDto;
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

public class ColumnDto extends GenericDto {

    private String name;
    private Project project_id;
    private int position;
    private String icon;
    private Boolean active;

    @Builder(builderMethodName = "childBuilder")
    public ColumnDto(Long id, String name, Project project_id, int position, String icon, Boolean active) {
        super(id);
        this.name = name;
        this.project_id = project_id;
        this.position = position;
        this.icon = icon;
        this.active = active;
    }


}
