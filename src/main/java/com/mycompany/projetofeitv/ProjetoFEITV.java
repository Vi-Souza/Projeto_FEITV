package com.mycompany.projetofeitv;

/**
 * Classe principal do projeto FEItv.
 * Aqui é onde o programa começa a ser executado.
 * 
 * @author Vitor
 */

import com.mycompany.projetofeitv.controller.UsuarioController;
import com.mycompany.projetofeitv.view.LoginView;

public class ProjetoFEITV {
    public static void main(String[] args) {
        // Cria o controller de usuários
        UsuarioController usuarioController = new UsuarioController();

        // Abre a tela de login como ponto inicial do sistema
        LoginView loginView = new LoginView(usuarioController);
        loginView.setVisible(true);
    }
}


