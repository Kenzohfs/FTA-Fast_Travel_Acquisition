package br.senai.sc.fasttravelacquisition.dto;

import org.springframework.stereotype.Repository;

import javax.persistence.Column;


public class EnderecoDTO {
    private Long id;
    private String pais;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private Integer numero;
    private String complemento;
}
