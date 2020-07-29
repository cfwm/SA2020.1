package br.sc.senai.repository;

import br.sc.senai.model.Escola;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface EscolaRepository extends CrudRepository<Escola, Integer> {

    @Query(value = "SELECT e FROM Escola e WHERE e.nome = :nome")
    Collection<Escola> findAllByName(@Param("nome") String nome);
}
