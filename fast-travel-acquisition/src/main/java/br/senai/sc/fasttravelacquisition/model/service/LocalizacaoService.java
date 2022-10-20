package br.senai.sc.fasttravelacquisition.model.service;

import br.senai.sc.fasttravelacquisition.model.entities.Localizacao;
import br.senai.sc.fasttravelacquisition.repository.LocalizacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalizacaoService {

    private LocalizacaoRepository localizacaoRepository;

    public Localizacao save(Localizacao localizacao) {
        return localizacaoRepository.save(localizacao);
    }

    public Optional<Localizacao> findById(Long id) {
        return localizacaoRepository.findById(id);
    }

    public List<Localizacao> findAll() {
        return localizacaoRepository.findAll();
    }

}
