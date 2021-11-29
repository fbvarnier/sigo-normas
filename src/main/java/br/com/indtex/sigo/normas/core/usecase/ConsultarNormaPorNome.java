package br.com.indtex.sigo.normas.core.usecase;

import br.com.indtex.sigo.normas.core.entity.factory.AnexoFactory;
import br.com.indtex.sigo.normas.core.response.ConsultarNormaResponseList;
import br.com.indtex.sigo.normas.core.usecase.interfaces.ConsultarNormaPorNomeInput;
import br.com.indtex.sigo.normas.gateway.database.NormaDS;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ConsultarNormaPorNome implements ConsultarNormaPorNomeInput {

    private final NormaDS normaDS;
    private final AnexoFactory anexoFactory;

    @Override
    public ConsultarNormaResponseList consultar(String nome) {

        var consultarNormaResponseList = new ConsultarNormaResponseList();
        normaDS.buscarNormasPorNomeLike(nome)
                .forEach(normaDM -> consultarNormaResponseList.add(normaDM.getId(),
                        normaDM.getCodigo(),
                        normaDM.getNome(),
                        normaDM.getDescricao(),
                        normaDM.getArea(),
                        normaDM.getTipo(),
                        normaDM.getAnexos()
                                .stream()
                                .map(anexoDM -> anexoFactory
                                        .criar(anexoDM.getId(), anexoDM.getNome(), anexoDM.getTipo(), anexoDM.getLink()))
                                .collect(Collectors.toList())));

        return consultarNormaResponseList;
    }
}
