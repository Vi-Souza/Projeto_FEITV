package com.mycompany.projetofeitv.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um Usuário dentro do sistema FEItv.
 * Cada usuário possui informações básicas de login e pode
 * gerenciar suas próprias listas de reprodução.
 */
public class Usuario {

    // Identificador único do usuário (chave primária no banco)
    private int id;

    // Nome do usuário (exibido na interface)
    private String nome;

    // Email do usuário (usado para login)
    private String email;

    // Senha do usuário (usada para autenticação)
    private String senha;

    // Coleção de listas de reprodução criadas pelo usuário
    private List<ListaReproducao> listasReproducao;

    /**
     * Construtor da classe Usuario.
     * Inicializa os atributos básicos e cria a lista de reprodução vazia.
     */
    public Usuario(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.listasReproducao = new ArrayList<>();
    }

    // ------------------- GETTERS -------------------

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }
    public List<ListaReproducao> getListasReproducao() { return listasReproducao; }

    // ------------------- SETTERS -------------------

    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }
    public void setSenha(String senha) { this.senha = senha; }

    // ------------------- MÉTODOS DE NEGÓCIO -------------------

    /**
     * Cria uma nova lista de reprodução e adiciona ao usuário.
     * @param nomeLista Nome da lista de reprodução
     */
    public void criarLista(String nomeLista) {
        listasReproducao.add(new ListaReproducao(nomeLista));
        System.out.println("Lista criada: " + nomeLista);
    }

    /**
     * Remove uma lista de reprodução pelo nome.
     * @param nomeLista Nome da lista a ser removida
     */
    public void removerLista(String nomeLista) {
        listasReproducao.removeIf(lista -> lista.getNome().equalsIgnoreCase(nomeLista));
        System.out.println("Lista removida: " + nomeLista);
    }
}
