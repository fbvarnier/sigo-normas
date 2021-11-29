package br.com.indtex.sigo.normas.core.usecase.interfaces;

import br.com.indtex.sigo.normas.core.request.AdicionarNovaNormaRequest;
import br.com.indtex.sigo.normas.core.response.AdicionarNovaNormaResponse;

public interface AdicionarNovaNormaInput {

    AdicionarNovaNormaResponse adicionar(AdicionarNovaNormaRequest request);
}
