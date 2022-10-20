package br.senai.sc.fasttravelacquisition.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "endereco")
@AllArgsConstructor
@NoArgsConstructor()
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 100)
    private String pais;

    @Column(nullable = false, length = 100)
    private String estado;

    @Column(nullable = false, length = 100)
    private String cidade;

    @Column(nullable = false, length = 100)
    private String bairro;

    @Column(nullable = false, length = 100)
    private String rua;

    @Column(length = 100)
    private Integer numero;

    @Column(length = 45)
    private String complemento;

}
