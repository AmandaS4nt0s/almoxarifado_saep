package Senai.Almoxarifado.Dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FerramentaDto {

    // Patrimônio da ferramenta
    @NotBlank(message = "O patrimônio é obrigatório")
    private String patrimonio;

    // Nome da ferramenta
    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    // Quantidade disponível
    @NotNull(message = "A quantidade é obrigatória")
    @Min(value = 1, message = "A quantidade deve ser maior que zero")
    private Integer quantidade;

    // Marca da ferramenta
    @NotBlank(message = "A marca é obrigatória")
    private String marca;

    // Localização da ferramenta no almoxarifado
    @NotBlank(message = "A localização é obrigatória")
    private String localizacao;


    // =========================
    // CONSTRUTOR
    // =========================

    public FerramentaDto() {
    }


    // =========================
    // GETTERS E SETTERS
    // =========================

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

