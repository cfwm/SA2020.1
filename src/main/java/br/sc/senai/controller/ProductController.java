package br.sc.senai.controller;

import br.sc.senai.model.Product;
import br.sc.senai.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController // Isto indica que esta classe é um Controller
//@RequestMapping(path = "/products")
@RequestMapping(path = "/api")
// Isto indica que a URL deve conter o caminho /product após a URL principal da aplicação
public class ProductController {

    // Isto significa obter automaticamente o objeto usuárioRepository,
    // que é gerado automaticamente pelo Spring. Vamos usá-lo para manipular os dados (DAO).
    @Autowired
    private ProductRepository productRepository;

    @PostMapping(path = "/products") // Endpoint que recebe apenas requisições POST para inclusão de usuários
    public @ResponseBody ResponseEntity<Product> addNewProduct(@RequestBody Product product) {
        try {
            Product newProduct = productRepository.save(product);
            return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(path = "/products") // Endpoint que recebe apenas requisições GET para retornar todos os usuários
    public @ResponseBody ResponseEntity<Iterable<Product>> getAllProducts() {

        try {
            Iterable<Product> products = productRepository.findAll();
            if (((Collection<?>) products).size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/products/{id}") // Endpoint que recebe apenas requisições DELETE para exclusão de usuários
    public @ResponseBody ResponseEntity<HttpStatus> removeProduct(@PathVariable("id") Integer id) {

        try {
            productRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/products/{id}") // Endpoint que recebe apenas requisições PUT para atualização de usuários
    public @ResponseBody ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {

        Optional<Product> productData = productRepository.findById(id);

        if (productData.isPresent()) {
            Product updatedProduct = productData.get();
            updatedProduct.setName(product.getName());
            updatedProduct.setDescription(product.getDescription());
            updatedProduct.setPrice(product.getPrice());
            updatedProduct.setCategoria(product.getCategoria());
            return new ResponseEntity<>(productRepository.save(updatedProduct), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/products/{name}")
    public @ResponseBody ResponseEntity<Product> allByName(@PathVariable String name, @RequestBody Product product){

        try{
            if (((Collection<?>) product).size() == 0){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
