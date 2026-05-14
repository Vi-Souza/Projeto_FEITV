package com.mycompany.projetofeitv.controller;

import com.mycompany.projetofeitv.model.Usuario;
import java.util.ArrayList;

/**
 * Classe UsuarioController
 * Responsável por gerenciar os usuários da plataforma FEItv.
 * 
 * Funções principais:
 * - Cadastrar novo usuário
 * - Fazer login
 * - Listar usuários cadastrados
 */
public class UsuarioController {
    
    // Lista que simula o banco de dados de usuários
    private ArrayList<Usuario> usuarios;
    
    // Construtor
    public UsuarioController() {
        this.usuarios = new ArrayList<>();
    }
    
    // Método para cadastrar novo usuário
    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado: " + usuario.getNome());
    }
    
    // Método para login
    public boolean login(String email, String senha) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equalsIgnoreCase(email) && u.getSenha().equals(senha)) {
                System.out.println("Login realizado com sucesso! Bem-vindo, " + u.getNome());
                return true;
            }
        }
        System.out.println("Falha no login: email ou senha incorretos.");
        return false;
    }
    
    // Método para listar todos os usuários
    public void listarUsuarios() {
        System.out.println("Lista de usuários cadastrados:");
        for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }
}
