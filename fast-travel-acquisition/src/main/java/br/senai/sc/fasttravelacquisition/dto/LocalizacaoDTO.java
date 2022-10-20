package br.senai.sc.fasttravelacquisition.dto;

import br.senai.sc.fasttravelacquisition.model.entities.TipoLocalizacao;
import lombok.Getter;

import java.util.Date;

@Getter
public class LocalizacaoDTO {

    private Long id;
    private TipoLocalizacao tipo;
    private Date horario;
    private Long viagem_id;
    private Long endereco_id;

}
