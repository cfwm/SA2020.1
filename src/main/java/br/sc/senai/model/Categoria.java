package br.sc.senai.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "categorias")
public class Categoria extends DateAudit {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @NotBlank
    @Size(max = 100)
    private String nome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
