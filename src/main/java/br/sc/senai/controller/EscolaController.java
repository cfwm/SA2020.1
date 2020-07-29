package br.sc.senai.controller;

import br.sc.senai.model.Escola;
import br.sc.senai.repository.EscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class EscolaController {

    @Autowired
    private EscolaRepository escolaRepository;

    @PostMapping(path = "/escolas") // Endpoint que recebe apenas requisições POST para inclusão de usuários
    public @ResponseBody ResponseEntity<Escola> addNewEscola(@RequestBody Escola escola) {
        try {
            Escola newEscola = escolaRepository.save(escola);
            return new ResponseEntity<>(newEscola, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }


    @GetMapping(path = "/escolas") // Endpoint que recebe apenas requisições GET para retornar todos os usuários
    public @ResponseBody ResponseEntity<Iterable<Escola>> getAllEscolas() {

        try {
            Iterable<Escola> escolas = escolaRepository.findAll();
            if (((Collection<?>) escolas).size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(escolas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/escolas/{id}") // Endpoint que recebe apenas requisições DELETE para exclusão de usuários
    public @ResponseBody ResponseEntity<HttpStatus> removeUser(@PathVariable("id") Integer id) {

        try {
            escolaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }


    @PutMapping("/escolas/{id}") // Endpoint que recebe apenas requisições PUT para atualização de usuários
    public @ResponseBody ResponseEntity<Escola> updateUser(@PathVariable("id") Integer id, @RequestBody Escola escola) {

        Optional<Escola> escolaData = escolaRepository.findById(id);

        if (escolaData.isPresent()) {
            Escola updatedEscola = escolaData.get();
            updatedEscola.setNome(escola.getNome());
            updatedEscola.setEmail(escola.getEmail());
            updatedEscola.setNome_responsavel(escola.getNome_responsavel());
            updatedEscola.setCelular_responsavel(escola.getCelular_responsavel());
            updatedEscola.setTelefone_escola(escola.getTelefone_escola());
            return new ResponseEntity<>(escolaRepository.save(updatedEscola), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/escolas/allbyname") // Endpoint que recebe apenas requisições POST para inclusão de usuários
    public @ResponseBody Iterable<Escola> findByName(@RequestParam String nome) {
        return escolaRepository.findAllByName(nome);
    }
}
