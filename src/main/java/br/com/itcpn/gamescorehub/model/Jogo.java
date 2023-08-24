package br.com.itcpn.gamescorehub.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_jogos")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_jogos")
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;

    private String descricao;
    @Column(name = "classificacao_indicativa")
    private Integer classificacaoIndicativa;
    private String capa;
    private String desenvolvedor;

    public Jogo() {
    }

    public Jogo(Long id, String nome, String descricao, Integer classificacaoIndicativa, String capa, String desenvolvedor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.classificacaoIndicativa = classificacaoIndicativa;
        this.capa = capa;
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

    public Integer getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(Integer classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public String getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setDesenvolvedor(String desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }
}
