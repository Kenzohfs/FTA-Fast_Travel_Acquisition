package br.senai.sc.fasttravelacquisition.model.service;

import br.senai.sc.fasttravelacquisition.model.entities.Veiculo;
import br.senai.sc.fasttravelacquisition.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoService {

    private VeiculoRepository veiculoRepository;

    public Veiculo save(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public Optional<Veiculo> findById(String placa) {
        return veiculoRepository.findById(placa);
    }

    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    public List<Veiculo> findByTipo(String tipo) {
        return veiculoRepository.findByTipo(tipo);
    }

    public void deleteById(String placa) {
        veiculoRepository.deleteById(placa);
    }

    public boolean existsById(String placa) {
        return veiculoRepository.existsById(placa);
    }
}
