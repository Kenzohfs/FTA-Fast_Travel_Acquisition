package br.senai.sc.fasttravelacquisition.model.service;

import br.senai.sc.fasttravelacquisition.model.entities.Pessoa;
import br.senai.sc.fasttravelacquisition.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PessoaService {
    private PessoaRepository pessoaRepository;

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public <S extends Pessoa> S save(S entity) {
        return pessoaRepository.save(entity);
    }

    public Optional<Pessoa> findById(String s) {
        return pessoaRepository.findById(s);
    }

    public boolean existsById(String s) {
        return pessoaRepository.existsById(s);
    }

    public void deleteById(String s) {
        pessoaRepository.deleteById(s);
    }
}
