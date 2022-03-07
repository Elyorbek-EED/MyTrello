package uz.boom.ergashov.entity.organization;

import lombok.Getter;
import lombok.Setter;
import uz.boom.ergashov.entity.Auditable;

import javax.persistence.*;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/7/2022
 * @project : mealDeliver
 */


@Getter
@Setter
@Entity
@Table(name = "organizations")
public class Organization extends Auditable {

    @Column(nullable = false, length = 100)
    private String name;

    private String logo;

    private String email;

    @Column(unique = true, nullable = false)
    private String code;

    @Column(name = "is_blocked", columnDefinition = "BOOLEAN default false")
    private boolean blocked;

    private String location;

    private Long owner;
}
