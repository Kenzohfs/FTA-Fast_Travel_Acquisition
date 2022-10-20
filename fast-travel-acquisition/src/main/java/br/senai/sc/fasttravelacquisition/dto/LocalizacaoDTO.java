package br.senai.sc.fasttravelacquisition.dto;

import br.senai.sc.fasttravelacquisition.model.entities.Endereco;
import br.senai.sc.fasttravelacquisition.model.entities.TipoLocalizacao;
import br.senai.sc.fasttravelacquisition.model.entities.Viagem;
import lombok.Getter;

import java.util.Date;

@Getter
public class LocalizacaoDTO {

    private Long id;
    private TipoLocalizacao tipo;
    private Date horario;
    private Viagem viagem;
    private Endereco endereco;

}
