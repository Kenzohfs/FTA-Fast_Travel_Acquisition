package br.senai.sc.fasttravelacquisition.dto;

import br.senai.sc.fasttravelacquisition.model.entities.Endereco;
import br.senai.sc.fasttravelacquisition.model.entities.TipoPessoa;

import java.util.Date;

public class PessoaDTO {
    private String cpf;
    private String nome;
    private Date dataNascimento;
    private String telefone;
    private String email;
    private TipoPessoa tipo;
    private Endereco endereco;
}
