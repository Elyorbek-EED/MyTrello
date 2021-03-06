package uz.boom.ergashov.entity.project;

import uz.boom.ergashov.entity.Auditable;
import uz.boom.ergashov.entity.organization.Organization;

import javax.persistence.*;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/7/2022
 * @project : mealDeliver
 */

@Entity
@Table(name = "project", schema = "etm")
public class Project extends Auditable {
    @Lob
    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "tz_path")
    private String tzPath;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organization organization_id;

    @Column(name = "closed",columnDefinition="BOOLEAN DEFAULT false")
    private Boolean closed;
/*

    @Convert(disableConversion = true)
    @Column(name = "createdat")
    private LocalDateTime createdat;

    @Column(name = "createby", nullable = false)
    private Long createby;

    @Convert(disableConversion = true)
    @Column(name = "updatedat")
    private Instant updatedat;

    @Column(name = "updateby")
    private Long updateby;
*/
/*

    public Long getUpdateby() {
        return updateby;
    }

    public void setUpdateby(Long updateby) {
        this.updateby = updateby;
    }

    public Instant getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Instant updatedat) {
        this.updatedat = updatedat;
    }

    public Long getCreateby() {
        return createby;
    }

    public void setCreateby(Long createby) {
        this.createby = createby;
    }

    public LocalDateTime getCreatedat() {
        return createdat;
    }

    public void setCreatedat(LocalDateTime createdat) {
        this.createdat = createdat;
    }
*/

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public Organization getOrganization() {
        return organization_id;
    }

    public void setOrganization(Organization organization) {
        this.organization_id = organization;
    }

    public String getTzPath() {
        return tzPath;
    }

    public void setTzPath(String tzPath) {
        this.tzPath = tzPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}