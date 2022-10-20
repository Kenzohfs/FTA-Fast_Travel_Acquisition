package br.senai.sc.fasttravelacquisition.controller;

import br.senai.sc.fasttravelacquisition.dto.PessoaDTO;
import br.senai.sc.fasttravelacquisition.model.entities.Pessoa;
import br.senai.sc.fasttravelacquisition.model.service.PessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("fast_travel_acquisition/pessoa")
public class PessoaController {
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(pessoaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaDTO, pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.save(pessoa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") String cpf) {
        if (!pessoaService.existsById(cpf)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar a pessoa!");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(pessoaService.findById(cpf));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") String cpf, @RequestBody @Valid PessoaDTO pessoaDTO) {
        if(!pessoaService.existsById(cpf)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar a pessoa!");
        }

        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaDTO, pessoa, "cpf");
        pessoa.setCpf(cpf);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.save(pessoa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") String cpf) {
        if (!pessoaService.existsById(cpf)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar a pessoa!");
        }
        pessoaService.deleteById(cpf);
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa deletada com sucesso!");
    }

}
