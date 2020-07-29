package br.sc.senai.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "produtos")
public class Product extends DateAudit {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Size(max = 100)
    private String description;

    @NotBlank
    @Size(max = 10)
    private Float price;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Category getCategoria() {
        return category;
    }

    public void setCategoria(Category category) {
        this.category = category;
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
