package br.sc.senai.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "escolas")
public class School extends DateAudit {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Size(max = 50)
    private String email;

    @NotBlank
    @Size(max = 100)
    private String responsible_name;

    @NotBlank
    @Size(max = 15)
    private String responsible_cellPhone;

    @NotBlank
    @Size(max = 15)
    private String school_phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResponsible_name() {
        return responsible_name;
    }

    public void setResponsible_name(String responsible_name) {
        this.responsible_name = responsible_name;
    }

    public String getResponsible_cellPhone() {
        return responsible_cellPhone;
    }

    public void setResponsible_cellPhone(String responsible_cellPhone) {
        this.responsible_cellPhone = responsible_cellPhone;
    }

    public String getSchool_phone() {
        return school_phone;
    }

    public void setSchool_phone(String school_phone) {
        this.school_phone = school_phone;
    }

    @Override
    public Boolean getStatus() {
        return super.getStatus();
    }

    @Override
    public void setStatus(Boolean status) {
        super.setStatus(status);
    }

    @Override
    public Date getCreatedAt() {
        return super.getCreatedAt();
    }

    @Override
    public void setCreatedAt(Date createdAt) {
        super.setCreatedAt(createdAt);
    }

    @Override
    public LocalDateTime getUpdatedAt() {
        return super.getUpdatedAt();
    }

    @Override
    public void setUpdatedAt(LocalDateTime updatedAt) {
        super.setUpdatedAt(updatedAt);
    }

    @Override
    public Integer getCreatedBy() {
        return super.getCreatedBy();
    }

    @Override
    public void setCreatedBy(Integer createdBy) {
        super.setCreatedBy(createdBy);
    }

    @Override
    public Integer getUpdatedBy() {
        return super.getUpdatedBy();
    }

    @Override
    public void setUpdatedBy(Integer updatedBy) {
        super.setUpdatedBy(updatedBy);
    }
}
