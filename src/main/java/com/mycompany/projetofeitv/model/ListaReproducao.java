package com.mycompany.projetofeitv.model;

import java.util.ArrayList;

/**
 * Classe ListaReproducao
 * Representa uma lista de vídeos favoritos de um usuário.
 * 
 * Cada lista tem:
 * - um nome
 * - uma coleção de vídeos (ArrayList)
 */
public class ListaReproducao {
    
    private String nome;                   // nome da playlist (ex: "Meus Favoritos")
    private ArrayList<Video> videos;       // lista de vídeos
    
    // Construtor
    public ListaReproducao(String nome) {
        this.nome = nome;
        this.videos = new ArrayList<>(); // começa vazia
    }
    
    // Métodos principais
    public void adicionarVideo(Video video) {
        videos.add(video);
    }
    
    public void removerVideo(Video video) {
        videos.remove(video);
    }
    
    public void listarVideos() {
        System.out.println("Playlist: " + nome);
        for (Video v : videos) {
            System.out.println(v);
        }
    }
    
    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public ArrayList<Video> getVideos() { return videos; }
}
