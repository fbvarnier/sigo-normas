package br.com.indtex.sigo.normas.core.entity.factory;

import br.com.indtex.sigo.normas.core.entity.Anexo;

public interface AnexoFactory {

    Anexo criar(long id, String nome, String tipo, String link);
}
