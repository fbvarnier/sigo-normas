package br.com.indtex.sigo.normas.core.entity.impl;

import br.com.indtex.sigo.normas.core.entity.Anexo;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AnexoImpl  implements Anexo {

    private final long id;
    private final String nome;
    private final String tipo;
    private final String link;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public String getLink() {
        return link;
    }
}
