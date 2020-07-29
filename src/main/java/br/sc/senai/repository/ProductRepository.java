package br.sc.senai.repository;

import br.sc.senai.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query(value = "SELECT p FROM Product p WHERE p.name = :name")
    Collection<Product> findAllByName(@Param("name") String name);
}
