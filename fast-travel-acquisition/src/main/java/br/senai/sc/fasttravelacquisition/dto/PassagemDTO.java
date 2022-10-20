package br.senai.sc.fasttravelacquisition.dto;

import br.senai.sc.fasttravelacquisition.model.entities.Endereco;
import br.senai.sc.fasttravelacquisition.model.entities.Pessoa;
import br.senai.sc.fasttravelacquisition.model.entities.Viagem;

import javax.persistence.Column;

public class PassagemDTO {
    private Long id;
    private Long numAssento;
    private Viagem viagem;
    private Pessoa pessoa;
    private Endereco endereco;
}
