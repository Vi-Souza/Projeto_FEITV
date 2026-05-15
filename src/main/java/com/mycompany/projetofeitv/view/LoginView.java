package com.mycompany.projetofeitv.view;

import com.mycompany.projetofeitv.controller.UsuarioController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Tela de Login
 */
public class LoginView extends JFrame {

    private UsuarioController usuarioController;

    public LoginView() {
        usuarioController = new UsuarioController();

        setTitle("Login - Projeto FEITV");
        setSize(400, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout principal
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField(20);

        JLabel lblSenha = new JLabel("Senha:");
        JPasswordField txtSenha = new JPasswordField(20);

        JButton btnLogin = new JButton("Entrar");
        JButton btnCadastro = new JButton("Cadastrar");

        // Linha 1 - Email
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(lblEmail, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(txtEmail, gbc);

        // Linha 2 - Senha
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(lblSenha, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(txtSenha, gbc);

        // Linha 3 - Botões
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(btnLogin, gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(btnCadastro, gbc);

        add(panel);

        // Ações dos botões
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = txtEmail.getText();
                String senha = new String(txtSenha.getPassword());

                int idUsuario = usuarioController.login(email, senha);
                if (idUsuario != -1) {
                    JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
                    new MenuPrincipalView(idUsuario).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Email ou senha inválidos.");
                }
            }
        });

        btnCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CadastroView().setVisible(true);
                dispose();
            }
        });
    }
}
