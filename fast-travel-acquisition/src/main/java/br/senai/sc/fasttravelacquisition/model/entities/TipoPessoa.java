package br.senai.sc.fasttravelacquisition.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoPessoa {
    ADMIN("Admin"), CLIENTE("Cliente");
    String nome;
}
