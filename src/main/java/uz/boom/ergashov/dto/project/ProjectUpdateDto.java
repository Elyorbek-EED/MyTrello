package uz.boom.ergashov.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
public class ProjectUpdateDto extends GenericDto {

    private String name;
    private MultipartFile tzFile;
    private Boolean closed;

    @Builder(builderMethodName = "childBuilder")
    public ProjectUpdateDto(Long id, String name, MultipartFile tzFile, Boolean closed) {
        super(id);
        this.name = name;
        this.tzFile = tzFile;
        this.closed = closed;
    }
}
