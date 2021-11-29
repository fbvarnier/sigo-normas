package br.com.indtex.sigo.normas.core.usecase.interfaces;

import br.com.indtex.sigo.normas.core.response.ConsultarNormaResponseList;

public interface ConsultarNormaPorNomeInput {

    ConsultarNormaResponseList consultar(String nome);
}
