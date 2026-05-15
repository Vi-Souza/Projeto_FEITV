package com.mycompany.projetofeitv.controller;

import com.mycompany.projetofeitv.dao.FavoritosDAO;
import com.mycompany.projetofeitv.model.Video;
import java.util.List;

/**
 * Controller responsável por intermediar operações de Favoritos
 * entre a camada de View e o DAO.
 */
public class FavoritosController {

    private FavoritosDAO favoritosDAO;

    public FavoritosController() {
        this.favoritosDAO = new FavoritosDAO();
    }

    public void adicionarFavorito(int idUsuario, int idVideo) {
        favoritosDAO.adicionarFavorito(idUsuario, idVideo);
    }

    public void removerFavorito(int idUsuario, int idVideo) {
        favoritosDAO.removerFavorito(idUsuario, idVideo);
    }

    /**
     * Retorna a lista de favoritos de um usuário.
     * @param idUsuario ID do usuário
     * @return Lista de objetos Video
     */
    public List<Video> listarFavoritos(int idUsuario) {
        return favoritosDAO.listarFavoritos(idUsuario);
    }
}
