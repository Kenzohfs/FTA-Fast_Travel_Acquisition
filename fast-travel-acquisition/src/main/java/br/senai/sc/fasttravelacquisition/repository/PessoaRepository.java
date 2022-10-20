package br.senai.sc.fasttravelacquisition.repository;

import br.senai.sc.fasttravelacquisition.model.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, String> {
}
