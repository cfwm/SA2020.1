package br.sc.senai.repository;

import br.sc.senai.model.Group;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface GroupRepository extends CrudRepository<Group, Integer> {

    @Query(value = "SELECT g FROM Group g WHERE g.name = :name")
    Collection<Group> findAllByName(@Param("name") String name);

}
