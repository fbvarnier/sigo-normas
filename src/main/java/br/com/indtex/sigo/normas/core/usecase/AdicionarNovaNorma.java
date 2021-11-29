package br.com.indtex.sigo.normas.core.usecase;

import br.com.indtex.sigo.normas.core.entity.factory.AnexoFactory;
import br.com.indtex.sigo.normas.core.entity.factory.NormaFactory;
import br.com.indtex.sigo.normas.core.request.AdicionarNovaNormaRequest;
import br.com.indtex.sigo.normas.core.response.AdicionarNovaNormaResponse;
import br.com.indtex.sigo.normas.core.usecase.interfaces.AdicionarNovaNormaInput;
import br.com.indtex.sigo.normas.gateway.database.NormaDS;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdicionarNovaNorma implements AdicionarNovaNormaInput {

    private final NormaDS normaDS;
    private final NormaFactory normaFactory;
    private final AnexoFactory anexoFactory;

    @Override
    public AdicionarNovaNormaResponse adicionar(AdicionarNovaNormaRequest request) {
        var norma = normaFactory.criar(request);
        var normaDM = normaDS.save(null, norma);

        return new AdicionarNovaNormaResponse(normaDM.getCodigo(),
                normaDM.getNome(),
                normaDM.getDescricao(),
                normaDM.getArea(),
                normaDM.getTipo(),
                normaDM.getAnexos()
                        .stream()
                        .map(anexoDM -> anexoFactory
                                .criar(anexoDM.getId(), anexoDM.getNome(), anexoDM.getTipo(), anexoDM.getLink()))
                        .collect(Collectors.toList()));
    }
}
