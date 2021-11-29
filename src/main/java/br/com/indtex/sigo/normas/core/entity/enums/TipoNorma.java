package br.com.indtex.sigo.normas.core.entity.enums;

import lombok.Getter;

@Getter
public enum TipoNorma {
    ESPECIFICACAO("Especificação"),
    METODO_DE_TESTE("Método de teste"),
    PRATICA("Prática"),
    GUIA("Guia"),
    DEFINICAO("Definição"),
    UNIDADES("Unidades");

    TipoNorma(String descrição) {
        this.descrição = descrição;
    }
    private String descrição;
}
