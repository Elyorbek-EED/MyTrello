package uz.boom.ergashov.dto.file;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
public class ResourceDto {
    private String originalName;
    private String generatedName;
    private long size;
    private String contentType;
    private String path;
}
