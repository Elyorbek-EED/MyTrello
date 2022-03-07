package uz.boom.ergashov.dto;

import lombok.*;

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
public class GenericDto implements Dto {
    private Long id;
}
