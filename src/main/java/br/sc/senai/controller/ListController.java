package br.sc.senai.controller;

import br.sc.senai.model.List;
import br.sc.senai.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController // Isto indica que esta classe é um Controller
//@RequestMapping(path = "/lists")
@RequestMapping(path = "/api")
// Isto indica que a URL deve conter o caminho /list após a URL principal da aplicação
public class ListController {

    // Isto significa obter automaticamente o objeto usuárioRepository,
    // que é gerado automaticamente pelo Spring. Vamos usá-lo para manipular os dados (DAO).
    @Autowired
    private ListRepository listRepository;

    @PostMapping(path = "/lists") // Endpoint que recebe apenas requisições POST para inclusão de usuários
    public @ResponseBody ResponseEntity<List> addNewList(@RequestBody List list) {
        try {
            List newList = listRepository.save(list);
            return new ResponseEntity<>(newList, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(path = "/lists") // Endpoint que recebe apenas requisições GET para retornar todos os usuários
    public @ResponseBody ResponseEntity<Iterable<List>> getAllLists() {

        try {
            Iterable<List> lists = listRepository.findAll();
            if (((Collection<?>) lists).size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(lists, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/lists/{id}") // Endpoint que recebe apenas requisições DELETE para exclusão de usuários
    public @ResponseBody ResponseEntity<HttpStatus> removeList(@PathVariable("id") Integer id) {

        try {
            listRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/lists/{id}") // Endpoint que recebe apenas requisições PUT para atualização de usuários
    public @ResponseBody ResponseEntity<List> updateList(@PathVariable("id") Integer id, @RequestBody List list) {

        Optional<List> listData = listRepository.findById(id);

        if (listData.isPresent()) {
            List updatedList = listData.get();
            updatedList.setName(list.getName());
            updatedList.setGroup(list.getGroup());
            updatedList.setProduct(list.getProduct());
            return new ResponseEntity<>(listRepository.save(updatedList), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/lists/{name}")
    public @ResponseBody ResponseEntity<List> allByName(@PathVariable String name, @RequestBody List list){

        try{
            if (((Collection<?>) list).size() == 0){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List>(list, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
