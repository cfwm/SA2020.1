package br.sc.senai.repository;

import br.sc.senai.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

    @Query(value = "SELECT c FROM Category c WHERE c.name = :name")
    Collection<Category> findAllByName(@Param("name") String name);
}
