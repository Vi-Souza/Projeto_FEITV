package com.mycompany.projetofeitv.controller;

import com.mycompany.projetofeitv.model.Video;
import java.util.ArrayList;

/**
 * Classe VideoController
 * Responsável por gerenciar os vídeos no sistema FEItv.
 * 
 * Aqui simulamos um "banco de dados" usando ArrayList.
 * Futuramente, vamos substituir pelo PostgreSQL via JDBC.
 */
public class VideoController {
    
    // Lista que simula o banco de dados de vídeos
    private ArrayList<Video> videos;
    
    // Construtor
    public VideoController() {
        this.videos = new ArrayList<>();
    }
    
    // Método para cadastrar um novo vídeo
    public void cadastrarVideo(Video video) {
        videos.add(video);
        System.out.println("Vídeo cadastrado: " + video.getTitulo());
    }
    
    // Método para buscar vídeo pelo título
    public Video buscarVideo(String titulo) {
        for (Video v : videos) {
            if (v.getTitulo().equalsIgnoreCase(titulo)) {
                return v;
            }
        }
        return null; // retorna null se não encontrar
    }
    
    // Método para listar todos os vídeos
    public void listarVideos() {
        System.out.println("Lista de vídeos cadastrados:");
        for (Video v : videos) {
            System.out.println(v);
        }
    }
    
    // Método para remover vídeo
    public void removerVideo(Video video) {
        videos.remove(video);
        System.out.println("Vídeo removido: " + video.getTitulo());
    }
    
    // Novo método para retornar a lista de vídeos (usado na VideoView)
    public ArrayList<Video> getVideos() {
        return videos;
    }
}
