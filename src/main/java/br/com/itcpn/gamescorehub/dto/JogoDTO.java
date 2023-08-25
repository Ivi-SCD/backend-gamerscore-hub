package br.com.itcpn.gamescorehub.dto;

import br.com.itcpn.gamescorehub.config.validations.ValidImageURL;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class JogoDTO {
    private Long id;
    @Size(min = 5, max = 100)
    @NotBlank(message = "O Nome do jogo não pode ser vazio")
    private String nome;
    @NotBlank(message = "A descrição do jogo não pode ser vazia")
    private String descricao;
    @NotNull(message = "A data de lancamento deve ser inserida")
    private LocalDate lancamento;
    @Pattern(regexp = "^(0|10|12|14|16|18)$", message = "A classificação deve ser um número entre  [0, 10, 12, 14, 16, 18]")
    @NotBlank(message = "A classificação não pode ser vazia")
    private String classificacao;
    @ValidImageURL
    @NotNull(message = "A URL da capa não pode ser vazia")
    private String capaURL;
    @DecimalMin(value = "0", message = "A nota de critica deve ser um número entre 0 e 100")
    @DecimalMax(value = "100", message = "A nota de critica deve ser um número entre 0 e 100")
    private Integer notaCritica;
    @NotNull(message = "O nome do desenvolvedor não pode ser vazio")
    private String desenvolvedor;

    public JogoDTO() {
    }

    public JogoDTO(String nome, String descricao, LocalDate lancamento, String classificacao, String capaURL, Integer notaCritica, String desenvolvedor) {
        this.nome = nome;
        this.descricao = descricao;
        this.lancamento = lancamento;
        this.classificacao = classificacao;
        this.capaURL = capaURL;
        this.notaCritica = notaCritica;
        this.desenvolvedor = desenvolvedor;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getLancamento() {
        return lancamento;
    }

    public void setLancamento(LocalDate lancamento) {
        this.lancamento = lancamento;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getCapaURL() {
        return capaURL;
    }

    public void setCapaURL(String capaURL) {
        this.capaURL = capaURL;
    }

    public Integer getNotaCritica() {
        return notaCritica;
    }

    public void setNotaCritica(Integer notaCritica) {
        this.notaCritica = notaCritica;
    }

    public String getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setDesenvolvedor(String desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }
}
