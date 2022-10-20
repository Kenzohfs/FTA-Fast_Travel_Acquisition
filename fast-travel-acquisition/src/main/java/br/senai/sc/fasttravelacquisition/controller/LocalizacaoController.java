package br.senai.sc.fasttravelacquisition.controller;

import br.senai.sc.fasttravelacquisition.dto.LocalizacaoDTO;
import br.senai.sc.fasttravelacquisition.dto.VeiculoDTO;
import br.senai.sc.fasttravelacquisition.model.entities.Localizacao;
import br.senai.sc.fasttravelacquisition.model.entities.Veiculo;
import br.senai.sc.fasttravelacquisition.model.entities.Viagem;
import br.senai.sc.fasttravelacquisition.model.service.LocalizacaoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/fast_travel_acquisition/localizacao")
public class LocalizacaoController {
    private LocalizacaoService service;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid LocalizacaoDTO localizacaoDTO) {
        if (service.existsById(localizacaoDTO.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Veículo já cadastrado!");
        }

        Localizacao localizacao = new Localizacao();
        BeanUtils.copyProperties(localizacaoDTO, localizacao);
        return ResponseEntity.status(HttpStatus.OK).body(service.save(localizacao));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        if (service.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O veículo de código: " + id + " não foi encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @GetMapping("/viagem/{viagem}")
    public ResponseEntity<List<Localizacao>> findByViagem(@PathVariable(value = "viagem") Viagem viagem) {
        return ResponseEntity.status(HttpStatus.FOUND).body(service.findByViagem(viagem));
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(service.findAll());
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody @Valid LocalizacaoDTO localizacaoDTO) {
        if (service.existsById(localizacaoDTO.getId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Localização não encontrada!");
        }

        Localizacao localizacao = service.findById(localizacaoDTO.getId()).get();
        BeanUtils.copyProperties(localizacaoDTO, localizacao);
        return ResponseEntity.status(HttpStatus.OK).body(service.save(localizacao));
    }

    @Transactional
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id) {
        if (service.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Localização não encontrada!");
        }

        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Localização de id: " + id + " foi deletada com sucesso!");
    }
}
