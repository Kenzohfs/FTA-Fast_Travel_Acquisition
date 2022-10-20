package br.senai.sc.fasttravelacquisition.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "localizacao")
@AllArgsConstructor
@NoArgsConstructor()
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Localizacao {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 20, nullable = false)
    private TipoLocalizacao tipo;

    @Column(nullable = false)
    private Date data;

    @ManyToOne
    @JoinColumn(name = "viagem_id")
    private Long viagem_id;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Long endereco_id;
}
