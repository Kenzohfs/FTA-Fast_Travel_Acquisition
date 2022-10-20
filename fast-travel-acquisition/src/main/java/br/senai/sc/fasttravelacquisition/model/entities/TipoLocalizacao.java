package br.senai.sc.fasttravelacquisition.model.entities;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TipoLocalizacao {

    PARTIDA("Partida"),
    DESTINO("Destino"),
    PARADA("Parada");

    private String tipoLocalizacao;

}
