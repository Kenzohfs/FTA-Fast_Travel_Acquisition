package br.senai.sc.fasttravelacquisition.repository;

import br.senai.sc.fasttravelacquisition.model.entities.Passagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassagemRepository extends JpaRepository<Passagem, Long> {
}
