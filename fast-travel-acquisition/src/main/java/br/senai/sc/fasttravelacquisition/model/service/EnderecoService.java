package br.senai.sc.fasttravelacquisition.model.service;

import br.senai.sc.fasttravelacquisition.model.entities.Endereco;
import br.senai.sc.fasttravelacquisition.repository.EnderecoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EnderecoService {
    private EnderecoRepository enderecoRepository;

    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public <S extends Endereco> S save(S entity) {
        return enderecoRepository.save(entity);
    }

    public Optional<Endereco> findById(Long id) {
        return enderecoRepository.findById(id);
    }

    public boolean existsById(Long id) {
        return enderecoRepository.existsById(id);
    }

    public void deleteById(Long id) {
        enderecoRepository.deleteById(id);
    }
}
