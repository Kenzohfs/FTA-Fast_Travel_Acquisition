package br.senai.sc.fasttravelacquisition.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pessoa")
@AllArgsConstructor
@NoArgsConstructor()
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Pessoa {
    @Id
    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(nullable = false)
    private Date dataNascimento;

    @Column(length = 11, nullable = false)
    private String telefone;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 25, nullable = false)
    private TipoPessoa tipo;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
}
