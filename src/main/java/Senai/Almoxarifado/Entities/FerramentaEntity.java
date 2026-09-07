package Senai.Almoxarifado.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ferramentas")
public class FerramentaEntity {

    // =========================
    // ID
    // =========================

    // O banco gera o ID automaticamente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // =========================
    // PATRIMÔNIO
    // =========================

    // Número de patrimônio da ferramenta.
    @Column(nullable = false, unique = true)
    private String patrimonio;


    // =========================
    // NOME
    // =========================

    @Column(nullable = false)
    private String nome;


    // =========================
    // QUANTIDADE
    // =========================

    @Column(nullable = false)
    private Integer quantidade;


    // =========================
    // MARCA
    // =========================

    @Column(nullable = false)
    private String marca;


    // =========================
    // LOCALIZAÇÃO
    // =========================

    @Column(nullable = false)
    private String localizacao;


    // =========================
    // CONSTRUTOR
    // =========================

    public FerramentaEntity() {
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

    public String getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
