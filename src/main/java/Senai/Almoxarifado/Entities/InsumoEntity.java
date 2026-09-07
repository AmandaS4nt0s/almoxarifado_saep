package Senai.Almoxarifado.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "insumos")
public class InsumoEntity {

    // =========================
    // ID
    // =========================

    // O banco gera automaticamente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // =========================
    // CÓDIGO
    // =========================

    @Column(nullable = false, unique = true)
    private Integer codigo;


    // =========================
    // INSUMO
    // =========================

    @Column(nullable = false)
    private String nome;


    // =========================
    // QUANTIDADE
    // =========================

    @Column(nullable = false)
    private Integer quantidade;


    // =========================
    // CONSTRUTOR
    // =========================

    public InsumoEntity() {
    }


    // =========================
    // GETTERS E SETTERS
    // =========================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
