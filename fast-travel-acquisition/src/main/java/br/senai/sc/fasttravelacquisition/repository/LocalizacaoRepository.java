package br.senai.sc.fasttravelacquisition.repository;

import br.senai.sc.fasttravelacquisition.model.entities.Localizacao;
import br.senai.sc.fasttravelacquisition.model.entities.Viagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalizacaoRepository extends JpaRepository<Localizacao, Integer> {

    List<Localizacao> findByViagem(Viagem viagem);

}

