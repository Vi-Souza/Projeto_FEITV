package com.mycompany.projetofeitv.view;

import com.mycompany.projetofeitv.controller.VideoController;
import com.mycompany.projetofeitv.controller.FavoritosController;
import com.mycompany.projetofeitv.model.Video;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Tela principal após login.
 */
public class MenuPrincipalView extends JFrame {

    private VideoController videoController;
    private FavoritosController favoritosController;
    private int idUsuarioLogado; // ID do usuário logado

    // Área de texto para mostrar vídeos e favoritos
    private JTextArea txtAreaVideos;

    public MenuPrincipalView(int idUsuario) {
        this.videoController = new VideoController();
        this.favoritosController = new FavoritosController();
        this.idUsuarioLogado = idUsuario;

        setTitle("Menu Principal - Projeto FEITV");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Botões principais
        JButton btnListarVideos = new JButton("Listar Vídeos");
        JButton btnBuscarVideo = new JButton("Buscar Vídeo");
        JButton btnCurtirVideo = new JButton("Curtir Vídeo");
        JButton btnDescurtirVideo = new JButton("Descurtir Vídeo");
        JButton btnFavoritos = new JButton("Meus Favoritos");
        JButton btnAdicionarFavorito = new JButton("Adicionar Favorito");
        JButton btnRemoverFavorito = new JButton("Remover Favorito");
        JButton btnLogout = new JButton("Logout");

        // Área de texto para exibir resultados
        txtAreaVideos = new JTextArea(15, 50);
        txtAreaVideos.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtAreaVideos);

        // Painel de botões
        JPanel panelButtons = new JPanel();
        panelButtons.add(btnListarVideos);
        panelButtons.add(btnBuscarVideo);
        panelButtons.add(btnCurtirVideo);
        panelButtons.add(btnDescurtirVideo);
        panelButtons.add(btnFavoritos);
        panelButtons.add(btnAdicionarFavorito);
        panelButtons.add(btnRemoverFavorito);
        panelButtons.add(btnLogout);

        // Layout principal
        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.add(panelButtons);
        panelMain.add(scrollPane);

        add(panelMain);

        // Ações dos botões
        btnListarVideos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Video> videos = videoController.listarVideos();
                txtAreaVideos.setText(""); // limpa antes
                if (videos.isEmpty()) {
                    txtAreaVideos.append("Nenhum vídeo encontrado.\n");
                } else {
                    for (Video v : videos) {
                        txtAreaVideos.append(v.toString() + "\n");
                    }
                }
            }
        });

        btnBuscarVideo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = JOptionPane.showInputDialog("Digite o título para buscar:");
                List<Video> videos = videoController.buscarPorTitulo(titulo);
                txtAreaVideos.setText("");
                if (videos.isEmpty()) {
                    txtAreaVideos.append("Nenhum vídeo encontrado com esse título.\n");
                } else {
                    for (Video v : videos) {
                        txtAreaVideos.append(v.toString() + "\n");
                    }
                }
            }
        });

        btnCurtirVideo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idVideo = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do vídeo para curtir:"));
                videoController.curtirVideo(idVideo);
                JOptionPane.showMessageDialog(null, "Vídeo curtido com sucesso!");
            }
        });

        btnDescurtirVideo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idVideo = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do vídeo para descurtir:"));
                videoController.descurtirVideo(idVideo);
                JOptionPane.showMessageDialog(null, "Curtida removida com sucesso!");
            }
        });

        btnFavoritos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Video> favoritos = favoritosController.listarFavoritos(idUsuarioLogado);
                txtAreaVideos.setText("");
                if (favoritos.isEmpty()) {
                    txtAreaVideos.append("Nenhum favorito encontrado.\n");
                } else {
                    for (Video v : favoritos) {
                        txtAreaVideos.append(v.toString() + "\n");
                    }
                }
            }
        });

        btnAdicionarFavorito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idVideo = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do vídeo para adicionar aos favoritos:"));
                favoritosController.adicionarFavorito(idUsuarioLogado, idVideo);
                JOptionPane.showMessageDialog(null, "Vídeo adicionado aos favoritos!");
            }
        });

        btnRemoverFavorito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idVideo = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do vídeo para remover dos favoritos:"));
                favoritosController.removerFavorito(idUsuarioLogado, idVideo);
                JOptionPane.showMessageDialog(null, "Vídeo removido dos favoritos!");
            }
        });

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginView().setVisible(true);
                dispose();
            }
        });
    }
}
