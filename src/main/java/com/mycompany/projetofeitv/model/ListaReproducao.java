package com.mycompany.projetofeitv.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa uma Lista de Reprodução.
 * Cada lista pertence a um usuário e contém vários vídeos.
 */
public class ListaReproducao {

    // Nome da lista de reprodução (ex.: "Favoritos", "Aulas", "Filmes")
    private String nome;

    // Coleção de vídeos que fazem parte desta lista
    private List<Video> videos;

    /**
     * Construtor da classe ListaReproducao.
     * Inicializa a lista com um nome e cria a coleção de vídeos vazia.
     * @param nome Nome da lista de reprodução
     */
    public ListaReproducao(String nome) {
        this.nome = nome;
        this.videos = new ArrayList<>();
    }

    // ------------------- GETTERS -------------------

    public String getNome() { return nome; }
    public List<Video> getVideos() { return videos; }

    // ------------------- SETTERS -------------------

    public void setNome(String nome) { this.nome = nome; }

    // ------------------- MÉTODOS DE NEGÓCIO -------------------

    /**
     * Adiciona um vídeo à lista de reprodução.
     * @param video Objeto do tipo Video (Filme ou Série)
     */
    public void adicionarVideo(Video video) {
        videos.add(video);
        System.out.println("Vídeo adicionado à lista: " + video.getTitulo());
    }

    /**
     * Remove um vídeo da lista de reprodução.
     * @param video Objeto do tipo Video a ser removido
     */
    public void removerVideo(Video video) {
        videos.remove(video);
        System.out.println("Vídeo removido da lista: " + video.getTitulo());
    }

    /**
     * Exibe todos os vídeos da lista.
     */
    public void listarVideos() {
        System.out.println("Lista: " + nome);
        for (Video v : videos) {
            v.exibirDetalhes();
        }
    }
}
