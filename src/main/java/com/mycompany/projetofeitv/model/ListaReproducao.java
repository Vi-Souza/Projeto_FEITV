package com.mycompany.projetofeitv.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa uma lista de reprodução de vídeos.
 */
public class ListaReproducao {

    private String nome;
    private List<Video> videos;

    public ListaReproducao(String nome) {
        this.nome = nome;
        this.videos = new ArrayList<>();
    }

    public void adicionarVideo(Video video) {
        videos.add(video);
    }

    public void removerVideo(Video video) {
        videos.remove(video);
    }

    public void listarVideos() {
        System.out.println("=== Lista de Reprodução: " + nome + " ===");
        for (Video v : videos) {
            System.out.println(v.toString());
        }
    }

    public List<Video> getVideos() {
        return videos;
    }

    public String getNome() {
        return nome;
    }
}
