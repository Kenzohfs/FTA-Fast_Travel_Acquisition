package br.senai.sc.fasttravelacquisition.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "veiculo")
@AllArgsConstructor
@NoArgsConstructor()
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Veiculo {

    @Id
    @Column(length = 45, nullable = false, unique = true)
    private String codigo;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 20, nullable = false)
    private TipoVeiculo tipo;

    @Column(nullable = false)
    private Integer qtd_assentos;
}
