package Senai.Almoxarifado.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


@Entity
@Table(name = "epis")
public class EpisEntity {

    // =========================
    // ID
    // =========================

    // O banco gera o ID automaticamente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // =========================
    // DADOS DO EPI
    // =========================

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private int quantidade;

    @Column(nullable = false)
    private int tamanho;


    // =========================
    // DATAS
    // =========================

    // Data em que o EPI foi fabricado
    @NotNull(message = "A data de fabricação é obrigatória")
    @Column(nullable = false)
    private LocalDate dataFabricacao;

    // Data de validade.
    // Será calculada no Service:
    // dataFabricacao + 5 anos
    @Column(nullable = false)
    private LocalDate validade;


    // =========================
    // LOCALIZAÇÃO
    // =========================

    @NotBlank(message = "A localização é obrigatória")
    @Column(name = "localizacao", nullable = false)
    private String localizacao;


    // =========================
    // CONSTRUTOR
    // =========================

    public EpisEntity() {
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
