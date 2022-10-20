package br.senai.sc.fasttravelacquisition.controller;

import br.senai.sc.fasttravelacquisition.dto.EnderecoDTO;
import br.senai.sc.fasttravelacquisition.model.entities.Endereco;
import br.senai.sc.fasttravelacquisition.model.service.EnderecoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/fast_travel_acquisition/endereco")
public class EnderecoController {
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(enderecoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid EnderecoDTO enderecoDTO) {
        System.out.println(enderecoDTO.toString());
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoDTO, endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.save(endereco));
    }

    @GetMapping("/{idEndereco}")
    public ResponseEntity<Object> findById(@PathVariable(value = "idEndereco") Long id) {
        if (!enderecoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar o endereço!");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(enderecoService.findById(id));
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<Object> update(@PathVariable(value = "idEndereco") Long idEndereco, @RequestBody @Valid EnderecoDTO enderecoDTO) {
        if(!enderecoService.existsById(idEndereco)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar o endereço!");
        }

        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoDTO, endereco, "id");
        endereco.setId(idEndereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.save(endereco));
    }

    @DeleteMapping("/{idEndereco}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "idEndereco") Long id) {
        if (!enderecoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar o endereço!");
        }
        enderecoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Endereço deletado com sucesso!");
    }
}
