package br.com.indtex.sigo.normas.core.usecase.interfaces;

import br.com.indtex.sigo.normas.core.response.ConsultarNormaResponse;

public interface ConsultarNormaPorCodigoInput {

    ConsultarNormaResponse consultar(String codigo);
}
