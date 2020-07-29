package br.sc.senai.controller;

import br.sc.senai.model.School;
import br.sc.senai.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class SchoolController {

    @Autowired
    private SchoolRepository schoolRepository;

    @PostMapping(path = "/schools") // Endpoint que recebe apenas requisições POST para inclusão de usuários
    public @ResponseBody ResponseEntity<School> addNewSchool(@RequestBody School school) {
        try {
            School newSchool = schoolRepository.save(school);
            return new ResponseEntity<>(newSchool, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }


    @GetMapping(path = "/schools") // Endpoint que recebe apenas requisições GET para retornar todos os usuários
    public @ResponseBody ResponseEntity<Iterable<School>> getAllSchools() {

        try {
            Iterable<School> schools = schoolRepository.findAll();
            if (((Collection<?>) schools).size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(schools, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/schools/{id}") // Endpoint que recebe apenas requisições DELETE para exclusão de usuários
    public @ResponseBody ResponseEntity<HttpStatus> removeUser(@PathVariable("id") Integer id) {

        try {
            schoolRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }


    @PutMapping("/schools/{id}") // Endpoint que recebe apenas requisições PUT para atualização de usuários
    public @ResponseBody ResponseEntity<School> updateUser(@PathVariable("id") Integer id, @RequestBody School school) {

        Optional<School> schoolData = schoolRepository.findById(id);

        if (schoolData.isPresent()) {
            School updatedSchool = schoolData.get();
            updatedSchool.setName(school.getName());
            updatedSchool.setEmail(school.getEmail());
            updatedSchool.setResponsible_name(school.getResponsible_name());
            updatedSchool.setResponsible_cellPhone(school.getResponsible_cellPhone());
            updatedSchool.setSchool_phone(school.getSchool_phone());
            return new ResponseEntity<>(schoolRepository.save(updatedSchool), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/schools/allbyname") // Endpoint que recebe apenas requisições POST para inclusão de usuários
    public @ResponseBody Iterable<School> findByName(@RequestParam String name) {
        return schoolRepository.findAllByName(name);
    }
}
