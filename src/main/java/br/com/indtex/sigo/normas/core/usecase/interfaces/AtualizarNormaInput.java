package br.com.indtex.sigo.normas.core.usecase.interfaces;

import br.com.indtex.sigo.normas.core.request.AtualizarNormaRequest;
import br.com.indtex.sigo.normas.core.response.AtualizarNormaResponse;

public interface AtualizarNormaInput {
    AtualizarNormaResponse atualizar(AtualizarNormaRequest request);
}
