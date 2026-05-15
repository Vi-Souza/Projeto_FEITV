package com.mycompany.projetofeitv.view;

import com.mycompany.projetofeitv.controller.UsuarioController;
import com.mycompany.projetofeitv.model.Usuario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Tela de Cadastro
 */
public class CadastroView extends JFrame {

    private UsuarioController usuarioController;

    public CadastroView() {
        usuarioController = new UsuarioController();

        setTitle("Cadastro - Projeto FEITV");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField(20);

        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField(20);

        JLabel lblSenha = new JLabel("Senha:");
        JPasswordField txtSenha = new JPasswordField(20);

        JButton btnSalvar = new JButton("Salvar");
        JButton btnVoltar = new JButton("Voltar");

        // Linha 1 - Nome
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(lblNome, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(txtNome, gbc);

        // Linha 2 - Email
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(lblEmail, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(txtEmail, gbc);

        // Linha 3 - Senha
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(lblSenha, gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(txtSenha, gbc);

        // Linha 4 - Botões
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(btnSalvar, gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        panel.add(btnVoltar, gbc);

        add(panel);

        // Ações dos botões
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario usuario = new Usuario(0, txtNome.getText(), txtEmail.getText(), new String(txtSenha.getPassword()));
                usuarioController.cadastrarUsuario(usuario);
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                new LoginView().setVisible(true);
                dispose();
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginView().setVisible(true);
                dispose();
            }
        });
    }
}
