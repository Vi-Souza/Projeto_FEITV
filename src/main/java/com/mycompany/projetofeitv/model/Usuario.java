package com.mycompany.projetofeitv.model;

/**
 * Classe Usuario
 * Representa um usuário da plataforma FEItv.
 * 
 * Cada usuário possui:
 * - um id único
 * - nome de usuário (login)
 * - senha
 * - email
 * 
 * Futuramente, podemos adicionar mais informações como data de cadastro.
 */
public class Usuario {
    
    // Atributos (características do usuário)
    private int id;             // identificador único no banco de dados
    private String nome;        // nome do usuário
    private String email;       // email do usuário
    private String senha;       // senha para login
    
    // Construtor — usado para criar objetos Usuario
    public Usuario(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    
    // Métodos Getters e Setters — permitem acessar e modificar os atributos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    // Método toString — útil para imprimir informações do usuário
    @Override
    public String toString() {
        return "Usuario{" + 
               "id=" + id + 
               ", nome='" + nome + '\'' + 
               ", email='" + email + '\'' + 
               '}';
    }
}
