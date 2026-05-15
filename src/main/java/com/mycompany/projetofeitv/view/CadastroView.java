package com.mycompany.projetofeitv.view;

import com.mycompany.projetofeitv.controller.UsuarioController;
import com.mycompany.projetofeitv.model.Usuario;
import javax.swing.*;
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

        // Componentes
        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField(20);

        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField(20);

        JLabel lblSenha = new JLabel("Senha:");
        JPasswordField txtSenha = new JPasswordField(20);

        JButton btnSalvar = new JButton("Salvar");
        JButton btnVoltar = new JButton("Voltar");

        // Layout simples
        JPanel panel = new JPanel();
        panel.add(lblNome);
        panel.add(txtNome);
        panel.add(lblEmail);
        panel.add(txtEmail);
        panel.add(lblSenha);
        panel.add(txtSenha);
        panel.add(btnSalvar);
        panel.add(btnVoltar);

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
