package br.sc.senai.repository;

import br.sc.senai.model.School;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface SchoolRepository extends CrudRepository<School, Integer> {

    @Query(value = "SELECT s FROM School s WHERE s.name = :name")
    Collection<School> findAllByName(@Param("name") String name);
}
