package com.mycompany.projetofeitv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VideoDAO {

    // Inserir vídeo
    public void inserirVideo(String titulo, String descricao, String tipo) {
        String sql = "INSERT INTO videos (titulo, descricao, tipo) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, titulo);
            stmt.setString(2, descricao);
            stmt.setString(3, tipo);
            stmt.executeUpdate();

            System.out.println("Vídeo inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir vídeo: " + e.getMessage());
        }
    }

    // Listar vídeos
    public List<String> listarVideos() {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT id, titulo, tipo, curtidas FROM videos";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String linha = rs.getInt("id") + " - " +
                               rs.getString("titulo") + " (" +
                               rs.getString("tipo") + ") - Curtidas: " +
                               rs.getInt("curtidas");
                lista.add(linha);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar vídeos: " + e.getMessage());
        }
        return lista;
    }
    
    // Incrementar curtidas de um vídeo pelo ID
    public void incrementarCurtidas(int idVideo) {
        String sql = "UPDATE videos SET curtidas = curtidas + 1 WHERE id = ?";
        try (Connection conn = ConexaoBD.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, idVideo);
        int linhasAfetadas = stmt.executeUpdate();

        if (linhasAfetadas > 0) {
            System.out.println("Curtida adicionada ao vídeo ID " + idVideo);
        } else {
            System.out.println("Nenhum vídeo encontrado com ID " + idVideo);
        }
        } catch (SQLException e) {
        System.out.println("Erro ao incrementar curtidas: " + e.getMessage());
    }
}

}

