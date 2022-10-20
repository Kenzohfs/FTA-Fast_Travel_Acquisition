package br.senai.sc.fasttravelacquisition.repository;

import br.senai.sc.fasttravelacquisition.model.entities.Passagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassagemRepository extends JpaRepository<Passagem, Long> {
}
