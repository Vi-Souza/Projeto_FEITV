package com.mycompany.projetofeitv.model;

/**
 * Classe que representa uma Série.
 */
public class Serie extends Video {

    public Serie(int id, String titulo, String descricao, int curtidas) {
        super(id, titulo, descricao, "Serie", curtidas);
    }

    public Serie(String titulo, String descricao, int curtidas) {
        super(titulo, descricao, "Serie", curtidas);
    }
}
