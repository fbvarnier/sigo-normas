package br.com.indtex.sigo.normas.core.entity.impl;

import br.com.indtex.sigo.normas.core.entity.Anexo;
import br.com.indtex.sigo.normas.core.entity.Norma;
import br.com.indtex.sigo.normas.core.entity.enums.TipoNorma;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class NormaImpl implements Norma {

    private final String codigo;
    private final String nome;
    private final String descricao;
    private final String area;
    private final TipoNorma tipo;
    private final List<Anexo> anexos;

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public String getArea() {
        return area;
    }

    @Override
    public TipoNorma getTipo() {
        return tipo;
    }

    @Override
    public List<Anexo> getAnexos() {
        return anexos;
    }
}
