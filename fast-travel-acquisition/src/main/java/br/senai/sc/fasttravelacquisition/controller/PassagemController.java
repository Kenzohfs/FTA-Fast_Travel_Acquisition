package br.senai.sc.fasttravelacquisition.controller;

import br.senai.sc.fasttravelacquisition.dto.PassagemDTO;
import br.senai.sc.fasttravelacquisition.model.entities.Passagem;
import br.senai.sc.fasttravelacquisition.model.service.PassagemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/fast_travel_acquisition/passagem")
public class PassagemController {
    private PassagemService passagemService;

    @GetMapping
    public ResponseEntity<List<Passagem>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(passagemService.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid PassagemDTO passagemDTO) {
        Passagem passagem = new Passagem();
        BeanUtils.copyProperties(passagemDTO, passagem);
        return ResponseEntity.status(HttpStatus.CREATED).body(passagemService.save(passagem));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(Long id) {
        if (!passagemService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar a passagem!");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(passagemService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid PassagemDTO passagemDTO) {
        if(!passagemService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar a passagem!");
        }

        Passagem passagem = new Passagem();
        BeanUtils.copyProperties(passagemDTO, passagem, "id");
        passagem.setId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(passagemService.save(passagem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(Long id) {
        if (!passagemService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar a passagem!");
        }
        passagemService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Passagem deletada com sucesso!");
    }
}
