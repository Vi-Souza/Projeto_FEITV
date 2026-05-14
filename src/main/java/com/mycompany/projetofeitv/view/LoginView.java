package com.mycompany.projetofeitv.view;

import com.mycompany.projetofeitv.controller.UsuarioController;
import com.mycompany.projetofeitv.controller.VideoController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {

    private UsuarioController usuarioController;
    private JTextField emailField;
    private JPasswordField senhaField;
    private JButton loginButton;
    private JButton cadastrarButton;

    public LoginView(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;

        setTitle("FEItv - Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        emailField = new JTextField(20);
        senhaField = new JPasswordField(20);
        loginButton = new JButton("Login");
        cadastrarButton = new JButton("Cadastrar");

        JPanel panel = new JPanel();
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Senha:"));
        panel.add(senhaField);
        panel.add(loginButton);
        panel.add(cadastrarButton);

        add(panel);

        // Botão de login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String senha = new String(senhaField.getPassword());

                boolean sucesso = usuarioController.login(email, senha);
                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
                    dispose(); // fecha a tela de login

                    // Abre a tela de vídeos
                    VideoController videoController = new VideoController();
                    VideoView videoView = new VideoView(videoController);
                    videoView.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Email ou senha incorretos.");
                }
            }
        });

        // Botão de cadastro
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String senha = new String(senhaField.getPassword());

                if (email.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                    return;
                }

                usuarioController.cadastrarUsuario(
                        new com.mycompany.projetofeitv.model.Usuario(
                                usuarioController.hashCode(), email, email, senha
                        )
                );
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            }
        });
    }
}
