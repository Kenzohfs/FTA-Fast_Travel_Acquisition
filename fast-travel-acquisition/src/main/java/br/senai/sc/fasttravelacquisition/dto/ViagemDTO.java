package br.senai.sc.fasttravelacquisition.dto;

import br.senai.sc.fasttravelacquisition.model.entities.Veiculo;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ViagemDTO {

    private Long id;
    private String partida;
    private String destino;
    private String hora_partida;
    private String hora_destino;
    private Double preco;
    private Veiculo veiculo;
}
