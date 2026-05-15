package com.mycompany.projetofeitv.dao;

import com.mycompany.projetofeitv.model.Video;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe DAO responsável por operações no banco de dados relacionadas a Vídeos.
 */
public class VideoDAO {

    /**
     * Lista todos os vídeos cadastrados no banco de dados.
     * @return Lista de objetos Video
     */
    public List<Video> listarVideos() {
        List<Video> videos = new ArrayList<>();
        String sql = "SELECT * FROM videos";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Video video = new Video(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("descricao"),
                    rs.getString("tipo"),
                    rs.getInt("curtidas")
                );
                videos.add(video);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar vídeos: " + e.getMessage());
        }
        return videos;
    }

    /**
     * Busca vídeos pelo título.
     * @param titulo Título ou parte do título
     * @return Lista de objetos Video
     */
    public List<Video> buscarPorTitulo(String titulo) {
        List<Video> videos = new ArrayList<>();
        String sql = "SELECT * FROM videos WHERE titulo ILIKE ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + titulo + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Video video = new Video(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("descricao"),
                    rs.getString("tipo"),
                    rs.getInt("curtidas")
                );
                videos.add(video);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar vídeo: " + e.getMessage());
        }
        return videos;
    }

    public void incrementarCurtidas(int idVideo) {
        String sql = "UPDATE videos SET curtidas = curtidas + 1 WHERE id = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idVideo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao curtir vídeo: " + e.getMessage());
        }
    }

    public void decrementarCurtidas(int idVideo) {
        String sql = "UPDATE videos SET curtidas = GREATEST(curtidas - 1, 0) WHERE id = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idVideo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao descurtir vídeo: " + e.getMessage());
        }
    }
}
