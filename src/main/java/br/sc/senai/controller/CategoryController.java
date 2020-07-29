package br.sc.senai.controller;

import br.sc.senai.model.Category;
import br.sc.senai.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController // Isto indica que esta classe é um Controller
//@RequestMapping(path = "/category")
@RequestMapping(path = "/api")
// Isto indica que a URL deve conter o caminho /category após a URL principal da aplicação
public class CategoryController {

    // Isto significa obter automaticamente o objeto usuárioRepository,
    // que é gerado automaticamente pelo Spring. Vamos usá-lo para manipular os dados (DAO).
    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping(path = "/category") // Endpoint que recebe apenas requisições POST para inclusão de usuários
    public @ResponseBody ResponseEntity<Category> addNewCategory(@RequestBody Category category) {
        try {
            Category newCategory = categoryRepository.save(category);
            return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(path = "/category") // Endpoint que recebe apenas requisições GET para retornar todos os usuários
    public @ResponseBody ResponseEntity<Iterable<Category>> getAllCategorys() {

        try {
            Iterable<Category> category = categoryRepository.findAll();
            if (((Collection<?>) category).size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/category/{id}") // Endpoint que recebe apenas requisições DELETE para exclusão de usuários
    public @ResponseBody ResponseEntity<HttpStatus> removeCategory(@PathVariable("id") Integer id) {

        try {
            categoryRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/category/{id}") // Endpoint que recebe apenas requisições PUT para atualização de usuários
    public @ResponseBody ResponseEntity<Category> updateCategory(@PathVariable("id") Integer id, @RequestBody Category category) {

        Optional<Category> categoryData = categoryRepository.findById(id);

        if (categoryData.isPresent()) {
            Category updatedCategory = categoryData.get();
            updatedCategory.setName(category.getName());
            return new ResponseEntity<>(categoryRepository.save(updatedCategory), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/category/{name}")
    public @ResponseBody ResponseEntity<Category> allByName(@PathVariable String name, @RequestBody Category category){

        try{
            if (((Collection<?>) category).size() == 0){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<Category>(category, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
