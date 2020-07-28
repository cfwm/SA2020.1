package br.sc.senai.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "escolas")
public class Escola extends DateAudit {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @NotBlank
    @Size(max = 100)
    private String nome;

    @NotBlank
    @Size(max = 50)
    private String email;

    @NotBlank
    @Size(max = 100)
    private String nome_responsavel;

    @NotBlank
    @Size(max = 15)
    private String celular_responsavel;

    @NotBlank
    @Size(max = 15)
    private String telefone_escola;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome_responsavel() {
        return nome_responsavel;
    }

    public void setNome_responsavel(String nome_responsavel) {
        this.nome_responsavel = nome_responsavel;
    }

    public String getCelular_responsavel() {
        return celular_responsavel;
    }

    public void setCelular_responsavel(String celular_responsavel) {
        this.celular_responsavel = celular_responsavel;
    }

    public String getTelefone_escola() {
        return telefone_escola;
    }

    public void setTelefone_escola(String telefone_escola) {
        this.telefone_escola = telefone_escola;
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
