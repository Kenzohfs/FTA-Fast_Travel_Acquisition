package br.senai.sc.fasttravelacquisition.model.service;

import br.senai.sc.fasttravelacquisition.model.entities.Passagem;
import br.senai.sc.fasttravelacquisition.repository.PassagemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PassagemService {
    private PassagemRepository passagemRepository;

    public List<Passagem> findAll() {
        return passagemRepository.findAll();
    }

    public <S extends Passagem> S save(S entity) {
        return passagemRepository.save(entity);
    }

    public Optional<Passagem> findById(Long aLong) {
        return passagemRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return passagemRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        passagemRepository.deleteById(aLong);
    }
}
