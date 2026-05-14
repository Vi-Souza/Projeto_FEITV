package com.mycompany.projetofeitv.model;

/**
 * Classe que representa uma Série.
 * Herda da classe abstrata Video e adiciona
 * atributos específicos de séries, como número de temporadas.
 */
public class Serie extends Video {

    // Quantidade de temporadas da série
    private int temporadas;

    /**
     * Construtor da classe Serie.
     * @param id Identificador único do vídeo
     * @param titulo Título da série
     * @param descricao Descrição da série
     * @param temporadas Número de temporadas
     */
    public Serie(int id, String titulo, String descricao, int temporadas) {
        super(id, titulo, descricao); // chama o construtor da classe Video
        this.temporadas = temporadas;
    }

    // ------------------- GETTERS -------------------

    public int getTemporadas() { return temporadas; }

    // ------------------- SETTERS -------------------

    public void setTemporadas(int temporadas) { this.temporadas = temporadas; }

    // ------------------- MÉTODO OBRIGATÓRIO -------------------

    /**
     * Implementação do método abstrato exibirDetalhes().
     * Exibe as informações específicas de uma série.
     */
    @Override
    public void exibirDetalhes() {
        System.out.println("Série: " + titulo +
                           " | Temporadas: " + temporadas +
                           " | Curtidas: " + curtidas);
    }
}
