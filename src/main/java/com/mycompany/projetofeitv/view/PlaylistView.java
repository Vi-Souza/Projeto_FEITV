package com.mycompany.projetofeitv.view;

import com.mycompany.projetofeitv.controller.VideoController;
import com.mycompany.projetofeitv.model.ListaReproducao;
import com.mycompany.projetofeitv.model.Video;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlaylistView extends JFrame {

    private VideoController videoController;
    private ListaReproducao playlist;

    private JComboBox<String> videoComboBox;
    private JButton adicionarButton;
    private JButton removerButton;
    private JTextArea playlistArea;

    public PlaylistView(VideoController videoController, ListaReproducao playlist) {
        this.videoController = videoController;
        this.playlist = playlist;

        setTitle("FEItv - Playlist de Favoritos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Componentes
        videoComboBox = new JComboBox<>();
        atualizarComboBox();

        adicionarButton = new JButton("Adicionar à Playlist");
        removerButton = new JButton("Remover da Playlist");
        playlistArea = new JTextArea(10, 40);
        playlistArea.setEditable(false);

        // Layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Linha 1 - ComboBox
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(new JLabel("Selecione um vídeo:"), gbc);
        gbc.gridy = 1;
        panel.add(videoComboBox, gbc);

        // Linha 2 - Botões
        gbc.gridy = 2; gbc.gridwidth = 1;
        panel.add(adicionarButton, gbc);
        gbc.gridx = 1;
        panel.add(removerButton, gbc);

        // Linha 3 - Área de playlist
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        panel.add(new JScrollPane(playlistArea), gbc);

        add(panel);

        // Ação adicionar
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = videoComboBox.getSelectedIndex();
                if (index >= 0) {
                    Video v = videoController.getVideos().get(index);
                    playlist.adicionarVideo(v);
                    atualizarPlaylistArea();
                }
            }
        });

        // Ação remover
        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = videoComboBox.getSelectedIndex();
                if (index >= 0) {
                    Video v = videoController.getVideos().get(index);
                    playlist.removerVideo(v);
                    atualizarPlaylistArea();
                }
            }
        });
    }

    // Atualiza a lista de vídeos no ComboBox
    private void atualizarComboBox() {
        videoComboBox.removeAllItems();
        for (Video v : videoController.getVideos()) {
            videoComboBox.addItem(v.getTitulo());
        }
    }

    // Atualiza a área de texto da playlist
    private void atualizarPlaylistArea() {
        playlistArea.setText("");
        for (Video v : playlist.getVideos()) {
            playlistArea.append(v.toString() + "\n");
        }
    }
}
