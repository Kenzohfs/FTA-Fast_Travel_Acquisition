package br.senai.sc.fasttravelacquisition.model.entities;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TipoVeiculo {

    AVIAO("Avião"),
    ONIBUS("Ônibus"),
    TREM("Trem");

    String tipo;

}
