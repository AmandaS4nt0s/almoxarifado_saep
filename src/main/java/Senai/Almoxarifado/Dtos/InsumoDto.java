package Senai.Almoxarifado.Dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class InsumoDto {

    // =========================
    // CÓDIGO
    // =========================

    @NotNull(message = "O código é obrigatório")
    private Integer codigo;


    // =========================
    // NOME
    // =========================

    @NotBlank(message = "O nome é obrigatório")
    private String nome;


    // =========================
    // QUANTIDADE
    // =========================

    @NotNull(message = "A quantidade é obrigatória")
    @Min(value = 0, message = "A quantidade não pode ser menor que zero")
    private Integer quantidade;


    // =========================
    // CONSTRUTOR
    // =========================

    public InsumoDto() {
    }


    // =========================
    // GETTERS E SETTERS
    // =========================

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

