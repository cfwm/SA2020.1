package br.sc.senai.controller;

import br.sc.senai.model.Group;
import br.sc.senai.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController // Isto indica que esta classe é um Controller
//@RequestMapping(path = "/groups")
@RequestMapping(path = "/api")
// Isto indica que a URL deve conter o caminho /group após a URL principal da aplicação
public class GroupController {

    // Isto significa obter automaticamente o objeto usuárioRepository,
    // que é gerado automaticamente pelo Spring. Vamos usá-lo para manipular os dados (DAO).
    @Autowired
    private GroupRepository groupRepository;

    @PostMapping(path = "/groups") // Endpoint que recebe apenas requisições POST para inclusão de usuários
    public @ResponseBody ResponseEntity<Group> addNewGroup(@RequestBody Group group) {
        try {
            Group newGroup = groupRepository.save(group);
            return new ResponseEntity<>(newGroup, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(path = "/groups") // Endpoint que recebe apenas requisições GET para retornar todos os usuários
    public @ResponseBody ResponseEntity<Iterable<Group>> getAllGroups() {

        try {
            Iterable<Group> groups = groupRepository.findAll();
            if (((Collection<?>) groups).size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(groups, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/groups/{id}") // Endpoint que recebe apenas requisições DELETE para exclusão de usuários
    public @ResponseBody ResponseEntity<HttpStatus> removeGroup(@PathVariable("id") Integer id) {

        try {
            groupRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/groups/{id}") // Endpoint que recebe apenas requisições PUT para atualização de usuários
    public @ResponseBody ResponseEntity<Group> updateGroup(@PathVariable("id") Integer id, @RequestBody Group group) {

        Optional<Group> groupData = groupRepository.findById(id);

        if (groupData.isPresent()) {
            Group updatedGroup = groupData.get();
            updatedGroup.setName(group.getName());
            updatedGroup.setSchool(group.getSchool());
            updatedGroup.setList(group.getList());
            return new ResponseEntity<>(groupRepository.save(updatedGroup), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/groups/{name}")
    public @ResponseBody ResponseEntity<Group> allByName(@PathVariable String name, @RequestBody Group group){

        try{
            if (((Collection<?>) group).size() == 0){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<Group>(group, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
