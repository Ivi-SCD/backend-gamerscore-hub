package br.com.itcpn.gamescorehub.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_jogos")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_jogos")
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 5000, nullable = false)
    private String descricao;

    @Temporal(TemporalType.DATE)
    private LocalDate lancamento;

    private String classificacao;
    @Column(name = "capa")
    private String capaURL;
    @Column(name = "nota_critica")
    private Integer notaCritica;
    private String desenvolvedor;

    public Jogo() {
    }

    public Jogo(Long id, String nome, String descricao, LocalDate lancamento, String classificacao, String capaURL, Integer notaCritica, String desenvolvedor) {
        this.id = id;
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

    public void setId(Long id) {
        this.id = id;
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
