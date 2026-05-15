package com.mycompany.projetofeitv.model;

/**
 * Classe que representa um Filme.
 */
public class Filme extends Video {

    public Filme(int id, String titulo, String descricao, int curtidas) {
        super(id, titulo, descricao, "Filme", curtidas);
    }

    public Filme(String titulo, String descricao, int curtidas) {
        super(titulo, descricao, "Filme", curtidas);
    }
}
