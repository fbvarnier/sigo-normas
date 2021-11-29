package br.com.indtex.sigo.normas.core.usecase;

import br.com.indtex.sigo.normas.core.entity.factory.AnexoFactory;
import br.com.indtex.sigo.normas.core.entity.factory.NormaFactory;
import br.com.indtex.sigo.normas.core.request.AtualizarNormaRequest;
import br.com.indtex.sigo.normas.core.response.AtualizarNormaResponse;
import br.com.indtex.sigo.normas.core.usecase.interfaces.AtualizarNormaInput;
import br.com.indtex.sigo.normas.gateway.database.NormaDS;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AtualizarNorma implements AtualizarNormaInput {

    private final NormaDS normaDS;
    private final NormaFactory normaFactory;
    private final AnexoFactory anexoFactory;

    @Override
    public AtualizarNormaResponse atualizar(AtualizarNormaRequest request) {
        var norma = normaFactory.criar(request);
        var normaDM = normaDS.save(request.getId(), norma);
        return new AtualizarNormaResponse(normaDM.getCodigo(),
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
