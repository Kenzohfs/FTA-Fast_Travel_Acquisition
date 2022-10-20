package br.senai.sc.fasttravelacquisition.controller;

import br.senai.sc.fasttravelacquisition.dto.ViagemDTO;
import br.senai.sc.fasttravelacquisition.model.entities.Viagem;
import br.senai.sc.fasttravelacquisition.model.service.ViagemService;
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
@RequestMapping("/fast_travel_acquisition/viagem")
public class ViagemController {

    private ViagemService viagemService;

    @GetMapping //Todas Viagens
    public ResponseEntity<List<Viagem>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(viagemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {

        if (!viagemService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID não encontrado!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(viagemService.findById(id));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Object> findByVeiculo(@PathVariable(value = "codigo") String id) {
        // Fazer Verificação

        return ResponseEntity.status(HttpStatus.OK).body(viagemService.findByVeiculo(id));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid ViagemDTO viagemDTO) {
        Viagem viagem = new Viagem();
        BeanUtils.copyProperties(viagemDTO, viagem);
        return ResponseEntity.status(HttpStatus.OK).body(viagemService.save(viagem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid ViagemDTO viagemDTO) {

        if(!viagemService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID não encontrado!");
        }

        Viagem viagem = new Viagem();
        BeanUtils.copyProperties(viagemDTO, viagem);
        viagem.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(viagemService.save(viagem));
    }
}
