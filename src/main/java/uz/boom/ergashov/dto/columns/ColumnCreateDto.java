package uz.boom.ergashov.dto.columns;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import uz.boom.ergashov.dto.Dto;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class  ColumnCreateDto implements Dto {

    private String name;
    private Project project_id;
    private int position;
    private MultipartFile icon;
}
