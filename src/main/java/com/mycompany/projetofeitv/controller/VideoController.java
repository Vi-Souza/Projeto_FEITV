package com.mycompany.projetofeitv.controller;

import com.mycompany.projetofeitv.dao.VideoDAO;
import com.mycompany.projetofeitv.model.Video;
import java.util.List;

/**
 * Controller responsável por intermediar operações de Vídeo
 * entre a camada de View e o DAO.
 */
public class VideoController {

    private VideoDAO videoDAO;

    public VideoController() {
        this.videoDAO = new VideoDAO();
    }

    /**
     * Lista todos os vídeos disponíveis.
     * @return Lista de objetos Video
     */
    public List<Video> listarVideos() {
        return videoDAO.listarVideos();
    }

    /**
     * Busca vídeos pelo título.
     * @param titulo Título ou parte do título
     * @return Lista de objetos Video
     */
    public List<Video> buscarPorTitulo(String titulo) {
        return videoDAO.buscarPorTitulo(titulo);
    }

    public void curtirVideo(int idVideo) {
        videoDAO.incrementarCurtidas(idVideo);
    }

    public void descurtirVideo(int idVideo) {
        videoDAO.decrementarCurtidas(idVideo);
    }
}
