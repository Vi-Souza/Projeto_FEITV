package com.mycompany.projetofeitv.view;

import com.mycompany.projetofeitv.controller.UsuarioController;
import javax.swing.*;
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
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField(20);

        JLabel lblSenha = new JLabel("Senha:");
        JPasswordField txtSenha = new JPasswordField(20);

        JButton btnLogin = new JButton("Entrar");
        JButton btnCadastro = new JButton("Cadastrar");

        JPanel panel = new JPanel();
        panel.add(lblEmail);
        panel.add(txtEmail);
        panel.add(lblSenha);
        panel.add(txtSenha);
        panel.add(btnLogin);
        panel.add(btnCadastro);

        add(panel);

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
