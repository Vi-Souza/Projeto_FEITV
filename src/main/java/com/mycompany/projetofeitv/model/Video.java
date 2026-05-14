package com.mycompany.projetofeitv.model;

/**
 * Classe Video
 * Representa um vídeo genérico na plataforma FEItv.
 * 
 * Pode ser usado para qualquer tipo de vídeo (YouTube, aula gravada, etc.)
 * dependendo do valor do atributo "tipo".
 */
public class Video {
    
    // Atributos principais
    private int id;             // identificador único no banco de dados
    private String titulo;      // título do vídeo
    private String descricao;   // descrição do vídeo
    private String tipo;        // tipo do vídeo (ex: "YouTube", "Aula", "Podcast")
    private int curtidas;       // quantidade de curtidas
    
    // Construtor
    public Video(int id, String titulo, String descricao, String tipo) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.curtidas = 0; // começa com zero curtidas
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

    // Métodos de negócio
    public void curtir() { this.curtidas++; }
    public void descurtir() { if (this.curtidas > 0) this.curtidas--; }
    
    @Override
    public String toString() {
        return "Video{" +
               "id=" + id +
               ", titulo='" + titulo + '\'' +
               ", descricao='" + descricao + '\'' +
               ", tipo='" + tipo + '\'' +
               ", curtidas=" + curtidas +
               '}';
    }
}

