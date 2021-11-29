package br.com.indtex.sigo.normas.core.entity.factory;

import br.com.indtex.sigo.normas.core.entity.Anexo;
import br.com.indtex.sigo.normas.core.entity.Norma;
import br.com.indtex.sigo.normas.core.request.DefaultNormaRequest;

import java.util.List;

public interface NormaFactory {

    Norma criar(String codigo, String nome, String descricao, String area, String tipo, List<Anexo> anexos);
    Norma criar(DefaultNormaRequest request);
}
