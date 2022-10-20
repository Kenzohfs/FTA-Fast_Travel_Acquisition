package br.senai.sc.fasttravelacquisition.model.service;

import br.senai.sc.fasttravelacquisition.model.entities.Localizacao;
import br.senai.sc.fasttravelacquisition.model.entities.Viagem;
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

    public List<Localizacao> findByViagem(Viagem viagem) {
        return localizacaoRepository.findByViagem(viagem);
    }

    public void deleteById(Long id) {
        localizacaoRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return localizacaoRepository.existsById(id);
    }

}
