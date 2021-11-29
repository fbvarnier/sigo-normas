package br.com.indtex.sigo.normas.core.usecase;

import br.com.indtex.sigo.normas.core.entity.factory.AnexoFactory;
import br.com.indtex.sigo.normas.core.entity.factory.NormaFactory;
import br.com.indtex.sigo.normas.core.request.AtualizarNormaRequest;
import br.com.indtex.sigo.normas.core.response.AtualizarNormaResponse;
import br.com.indtex.sigo.normas.core.response.ConsultarNormaResponse;
import br.com.indtex.sigo.normas.core.usecase.interfaces.AtualizarNormaInput;
import br.com.indtex.sigo.normas.core.usecase.interfaces.ConsultarNormaPorCodigoInput;
import br.com.indtex.sigo.normas.exception.RegistroNaoEncontradoException;
import br.com.indtex.sigo.normas.gateway.database.NormaDS;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ConsultarNormaPorCodigo implements ConsultarNormaPorCodigoInput {

    private final NormaDS normaDS;
    private final AnexoFactory anexoFactory;

    @Override
    public ConsultarNormaResponse consultar(String codigo) {
        var optNormaDM = normaDS.buscarNormaPorCodigo(codigo);
        if (optNormaDM.isEmpty())
            throw new RegistroNaoEncontradoException("Norma não encontrada.");
        var normaDM = optNormaDM.get();
        return new ConsultarNormaResponse(normaDM.getId(),
                normaDM.getCodigo(),
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
