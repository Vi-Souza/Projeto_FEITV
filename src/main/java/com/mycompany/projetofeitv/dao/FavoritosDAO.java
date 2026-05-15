package com.mycompany.projetofeitv.dao;

import com.mycompany.projetofeitv.model.Video;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe DAO responsável por operações no banco de dados relacionadas a Favoritos.
 */
public class FavoritosDAO {

    public void adicionarFavorito(int idUsuario, int idVideo) {
        String sql = "INSERT INTO favoritos (id_usuario, id_video) VALUES (?, ?)";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idVideo);
            stmt.executeUpdate();
            System.out.println("Vídeo adicionado aos favoritos!");
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar favorito: " + e.getMessage());
        }
    }

    public void removerFavorito(int idUsuario, int idVideo) {
        String sql = "DELETE FROM favoritos WHERE id_usuario = ? AND id_video = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idVideo);
            stmt.executeUpdate();
            System.out.println("Vídeo removido dos favoritos!");
        } catch (SQLException e) {
            System.out.println("Erro ao remover favorito: " + e.getMessage());
        }
    }

    /**
     * Lista todos os vídeos favoritos de um usuário.
     * @param idUsuario ID do usuário
     * @return Lista de objetos Video
     */
    public List<Video> listarFavoritos(int idUsuario) {
        List<Video> favoritos = new ArrayList<>();
        String sql = "SELECT v.* FROM videos v " +
                     "INNER JOIN favoritos f ON v.id = f.id_video " +
                     "WHERE f.id_usuario = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Video video = new Video(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("descricao"),
                    rs.getString("tipo"),
                    rs.getInt("curtidas")
                );
                favoritos.add(video);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar favoritos: " + e.getMessage());
        }
        return favoritos;
    }
}
