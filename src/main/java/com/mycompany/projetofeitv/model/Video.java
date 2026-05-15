package com.mycompany.projetofeitv.model;

/**
 * Classe base que representa um Vídeo.
 */
public class Video {

    protected int id;
    protected String titulo;
    protected String descricao;
    protected String tipo; // Filme ou Serie
    protected int curtidas;

    // Construtor completo
    public Video(int id, String titulo, String descricao, String tipo, int curtidas) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.curtidas = curtidas;
    }

    // Construtor sem ID (para inserções futuras)
    public Video(String titulo, String descricao, String tipo, int curtidas) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.curtidas = curtidas;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getCurtidas() { return curtidas; }
    public void setCurtidas(int curtidas) { this.curtidas = curtidas; }

    @Override
    public String toString() {
        return "ID: " + id +
               " | Título: " + titulo +
               " | Tipo: " + tipo +
               " | Curtidas: " + curtidas;
    }
}
