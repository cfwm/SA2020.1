package br.senai.edu.model;

public class Turma {
    private int id;
    private int escolaId;
    private int listaProdutosId;
    private int status;
    private int created_at;
    private int created_by;
    private int update_at;
    private int update_by;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEscolaId() {
        return escolaId;
    }

    public void setEscolaId(int escolaId) {
        this.escolaId = escolaId;
    }

    public int getListaProdutosId() {
        return listaProdutosId;
    }

    public void setListaProdutosId(int listaProdutosId) {
        this.listaProdutosId = listaProdutosId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public int getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(int update_at) {
        this.update_at = update_at;
    }

    public int getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(int update_by) {
        this.update_by = update_by;
    }
}
