package com.mycompany.projetofeitv.model;

/**
 * Classe abstrata que representa um Vídeo.
 * Serve como base para diferentes tipos de vídeos (Filme, Série).
 * Define atributos e comportamentos comuns, além de métodos abstratos
 * que devem ser implementados pelas subclasses.
 */
public abstract class Video {

    // Identificador único do vídeo (chave primária no banco)
    protected int id;

    // Título do vídeo
    protected String titulo;

    // Descrição do vídeo
    protected String descricao;

    // Quantidade de curtidas recebidas
    protected int curtidas;

    /**
     * Construtor da classe Video.
     * @param id Identificador único
     * @param titulo Título do vídeo
     * @param descricao Descrição do vídeo
     */
    public Video(int id, String titulo, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.curtidas = 0; // inicia com zero curtidas
    }

    // ------------------- GETTERS -------------------

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public int getCurtidas() { return curtidas; }

    // ------------------- SETTERS -------------------

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    // ------------------- MÉTODOS COMUNS -------------------

    /**
     * Incrementa o número de curtidas do vídeo.
     */
    public void curtir() { curtidas++; }

    /**
     * Decrementa o número de curtidas do vídeo (não pode ser menor que zero).
     */
    public void descurtir() { if (curtidas > 0) curtidas--; }

    // ------------------- MÉTODO ABSTRATO -------------------

    /**
     * Método abstrato que deve ser implementado pelas subclasses.
     * Cada tipo de vídeo (Filme, Série) exibirá seus detalhes de forma diferente.
     */
    public abstract void exibirDetalhes();
}
