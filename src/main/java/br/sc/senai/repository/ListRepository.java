package br.sc.senai.repository;

import br.sc.senai.model.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;

public interface ListRepository extends CrudRepository<List, Integer> {

    @Query(value = "SELECT u FROM List u WHERE u.name = :name")
    Collection<List> findAllByName(@Param("name") String name);

}
