package br.senai.sc.fasttravelacquisition.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "viagem")
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false, length = 100)
    private String partida;

    @Column(nullable = false, length = 100)
    private String destino;

    @Column(nullable = false)
    private String hora_partida;

    @Column(nullable = false)
    private String hora_destino;

    @Column(nullable = false)
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "codigo_veiculo", nullable = false)
    private Veiculo veiculo;
}
