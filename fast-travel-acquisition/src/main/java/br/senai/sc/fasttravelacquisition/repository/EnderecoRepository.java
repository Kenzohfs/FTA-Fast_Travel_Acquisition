package br.senai.sc.fasttravelacquisition.repository;

import br.senai.sc.fasttravelacquisition.model.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> { }

