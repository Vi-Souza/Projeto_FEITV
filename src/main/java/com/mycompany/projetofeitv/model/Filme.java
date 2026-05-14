package com.mycompany.projetofeitv.model;

/**
 * Classe que representa um Filme.
 * Herda da classe abstrata Video e adiciona
 * atributos específicos de filmes, como o diretor.
 */
public class Filme extends Video {

    // Nome do diretor do filme
    private String diretor;

    /**
     * Construtor da classe Filme.
     * @param id Identificador único do vídeo
     * @param titulo Título do filme
     * @param descricao Descrição do filme
     * @param diretor Nome do diretor
     */
    public Filme(int id, String titulo, String descricao, String diretor) {
        super(id, titulo, descricao); // chama o construtor da classe Video
        this.diretor = diretor;
    }

    // ------------------- GETTERS -------------------

    public String getDiretor() { return diretor; }

    // ------------------- SETTERS -------------------

    public void setDiretor(String diretor) { this.diretor = diretor; }

    // ------------------- MÉTODO OBRIGATÓRIO -------------------

    /**
     * Implementação do método abstrato exibirDetalhes().
     * Exibe as informações específicas de um filme.
     */
    @Override
    public void exibirDetalhes() {
        System.out.println("Filme: " + titulo +
                           " | Diretor: " + diretor +
                           " | Curtidas: " + curtidas);
    }
}
