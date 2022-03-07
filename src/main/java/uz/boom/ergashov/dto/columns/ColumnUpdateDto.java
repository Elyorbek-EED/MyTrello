package uz.boom.ergashov.dto.columns;

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

public class ColumnUpdateDto extends GenericDto {
    private String name;
    private MultipartFile icon;
    private Boolean actice;

    public ColumnUpdateDto(Long id, String name,  MultipartFile icon,Boolean actice) {
        super(id);
        this.name = name;
        this.icon = icon;
        this.actice = actice;
    }
}
