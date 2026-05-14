package com.mycompany.projetofeitv.view;

import com.mycompany.projetofeitv.controller.VideoController;
import com.mycompany.projetofeitv.model.ListaReproducao;
import com.mycompany.projetofeitv.model.Video;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VideoView extends JFrame {

    private VideoController videoController;
    private JButton listarButton;
    private JButton abrirPlaylistButton;
    private JTextArea listaArea;

    public VideoView(VideoController videoController) {
        this.videoController = videoController;

        setTitle("FEItv - Vídeos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        listarButton = new JButton("Listar Vídeos");
        abrirPlaylistButton = new JButton("Abrir Playlist");
        listaArea = new JTextArea(10, 40);
        listaArea.setEditable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Linha 1 - Botões
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(listarButton, gbc);
        gbc.gridx = 1;
        panel.add(abrirPlaylistButton, gbc);

        // Linha 2 - Área de listagem
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2;
        panel.add(new JScrollPane(listaArea), gbc);

        add(panel);

        // Botão listar
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaArea.setText("");
                for (Video v : videoController.getVideos()) {
                    listaArea.append(v.toString() + "\n");
                }
            }
        });

        // Botão abrir playlist
        abrirPlaylistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaReproducao favoritos = new ListaReproducao("Favoritos do Vitor");
                PlaylistView playlistView = new PlaylistView(videoController, favoritos);
                playlistView.setVisible(true);
            }
        });
    }
}
