package br.senai.sc.fasttravelacquisition.dto;

import br.senai.sc.fasttravelacquisition.model.entities.TipoVeiculo;
import lombok.Getter;

@Getter
public class VeiculoDTO {

    private String codigo;
    private TipoVeiculo tipo;
    private Integer qtd_assentos;

}
