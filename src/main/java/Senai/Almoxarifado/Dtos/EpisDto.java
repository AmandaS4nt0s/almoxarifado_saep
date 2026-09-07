package Senai.Almoxarifado.Dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


public class EpisDto {

    // ID do EPI
    // Não precisa ser informado no cadastro.
    // O banco gera automaticamente.
    private Long id;


    // =========================
    // DADOS DO EPI
    // =========================

    @NotBlank(message = "O nome é obrigatório")
    @Size(
            min = 3,
            max = 100,
            message = "O nome deve ter entre 3 e 100 caracteres"
    )
    private String nome;


    @Min(
            value = 0,
            message = "A quantidade não pode ser negativa"
    )
    private int quantidade;


    @Min(
            value = 0,
            message = "O tamanho não pode ser negativo"
    )
    private int tamanho;


    // =========================
    // DATA DE FABRICAÇÃO
    // =========================

    @NotNull(message = "A data de fabricação é obrigatória")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFabricacao;


    // =========================
    // LOCALIZAÇÃO
    // =========================

    @NotBlank(message = "A localização é obrigatória")
    private String localizacao;


    // =========================
    // CONSTRUTOR
    // =========================

    public EpisDto() {
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

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}

