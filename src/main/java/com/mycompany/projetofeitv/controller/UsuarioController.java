package com.mycompany.projetofeitv.controller;

import com.mycompany.projetofeitv.dao.UsuarioDAO;
import com.mycompany.projetofeitv.model.Usuario;

/**
 * Controller responsável por intermediar operações de Usuário
 * entre a camada de View e o DAO.
 */
public class UsuarioController {

    private UsuarioDAO usuarioDAO;

    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarioDAO.cadastrarUsuario(usuario);
    }

    /**
     * Realiza login e retorna o ID do usuário logado.
     * @return ID do usuário se login for válido, -1 caso contrário
     */
    public int login(String email, String senha) {
        return usuarioDAO.autenticarUsuario(email, senha);
    }

    public void atualizarUsuario(Usuario usuario) {
        usuarioDAO.atualizarUsuario(usuario);
    }

    public void excluirUsuario(int idUsuario) {
        usuarioDAO.excluirUsuario(idUsuario);
    }
}
