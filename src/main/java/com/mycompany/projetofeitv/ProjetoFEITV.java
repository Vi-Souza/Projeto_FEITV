package com.mycompany.projetofeitv;

import com.mycompany.projetofeitv.model.Video;
import com.mycompany.projetofeitv.controller.VideoController;
/**
 * Classe principal do projeto FEItv.
 * Aqui é onde o programa começa a ser executado.
 * 
 * @author Vitor
 */
public class ProjetoFEITV {
    public static void main(String[] args) {
        VideoController controller = new VideoController();
        
        // Criando vídeos
        Video v1 = new Video(1, "Aula de Java", "Introdução ao Java", "YouTube");
        Video v2 = new Video(2, "Swing Tutorial", "Como criar GUIs", "YouTube");
        
        // Cadastrando vídeos
        controller.cadastrarVideo(v1);
        controller.cadastrarVideo(v2);
        
        // Listando vídeos
        controller.listarVideos();
        
        // Buscando vídeo
        Video encontrado = controller.buscarVideo("Swing Tutorial");
        System.out.println("Vídeo encontrado: " + encontrado);
        
        // Removendo vídeo
        controller.removerVideo(v1);
        controller.listarVideos();
    }
}

