package com.mycompany.projetofeitv;

import com.mycompany.projetofeitv.view.LoginView;

/**
 * Classe principal do projeto FEITV.
 * Responsável por iniciar a aplicação.
 */
public class ProjetoFEITV {

    public static void main(String[] args) {
        // Inicia a aplicação mostrando a tela de Login
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }
}


