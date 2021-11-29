package br.com.indtex.sigo.normas.core.entity;

import br.com.indtex.sigo.normas.core.entity.enums.TipoNorma;

import java.util.List;

public interface Norma {

    String getCodigo();
    String getNome();
    String getDescricao();
    String getArea();
    TipoNorma getTipo();
    List<Anexo> getAnexos();
}
