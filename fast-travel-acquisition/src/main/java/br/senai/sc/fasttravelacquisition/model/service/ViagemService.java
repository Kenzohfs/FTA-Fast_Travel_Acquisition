package br.senai.sc.fasttravelacquisition.model.service;

import br.senai.sc.fasttravelacquisition.model.entities.Viagem;
import br.senai.sc.fasttravelacquisition.repository.ViagemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ViagemService {

    private ViagemRepository viagemRepository;

    public List<Viagem> findAll() {
        return viagemRepository.findAll();
    }

    public boolean existsById(Long id) {
        return viagemRepository.existsById(id);
    }

    public Object findById(Long id) {
        return viagemRepository.findById(id);
    }

    public Object findByVeiculo(String id) {
        return viagemRepository.findByVeiculo(id);
    }

    public Object save(Viagem viagem) {
        return viagemRepository.save(viagem);
    }
}
