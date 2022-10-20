package br.senai.sc.fasttravelacquisition.controller;

import br.senai.sc.fasttravelacquisition.dto.VeiculoDTO;
import br.senai.sc.fasttravelacquisition.model.entities.Veiculo;
import br.senai.sc.fasttravelacquisition.model.service.VeiculoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("fast_travel_acquisition/veiculo")
public class VeiculoController {
    private VeiculoService service;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid VeiculoDTO veiculoDTO) {
        if (service.existsById(veiculoDTO.getCodigo())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Veículo já cadastrado!");
        }

        Veiculo veiculo = new Veiculo();
        BeanUtils.copyProperties(veiculoDTO, veiculo);
        return ResponseEntity.status(HttpStatus.OK).body(service.save(veiculo));
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<Object> findById(@PathVariable(value = "codigo") String codigo){
        Optional<Veiculo> veiculoOptional = service.findById(codigo);
        if (veiculoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O veículo de código: " + codigo + " não foi encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(veiculoOptional.get());
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Veiculo>> findByTipo(@PathVariable(value = "tipo") String tipo) {
        return ResponseEntity.status(HttpStatus.FOUND).body(service.findByTipo(tipo));
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(service.findAll());
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody @Valid VeiculoDTO veiculoDTO) {
        if (service.existsById(veiculoDTO.getCodigo())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veículo não encontrado!");
        }

        Veiculo veiculo = service.findById(veiculoDTO.getCodigo()).get();
        BeanUtils.copyProperties(veiculoDTO, veiculo);
        return ResponseEntity.status(HttpStatus.OK).body(service.save(veiculo));
    }

    @Transactional
    @DeleteMapping("codigo/{codigo}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "codigo") String codigo) {
        if (service.existsById(codigo)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veículo não encontrado!");
        }

        service.deleteById(codigo);
        return ResponseEntity.status(HttpStatus.OK).body("Veículo de código: " + codigo + " foi deletado com sucesso!");
    }
}
