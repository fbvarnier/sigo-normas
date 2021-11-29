package br.com.indtex.sigo.normas.core.usecase;

import br.com.indtex.sigo.normas.core.entity.factory.AnexoFactory;
import br.com.indtex.sigo.normas.core.response.ConsultarNormaResponse;
import br.com.indtex.sigo.normas.core.usecase.interfaces.ConsultarNormaPorCodigoInput;
import br.com.indtex.sigo.normas.core.usecase.interfaces.RemoverNormaInput;
import br.com.indtex.sigo.normas.exception.RegistroNaoEncontradoException;
import br.com.indtex.sigo.normas.gateway.database.NormaDS;
import br.com.indtex.sigo.normas.gateway.database.model.NormaDataModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RemoverNorma implements RemoverNormaInput {

    private final NormaDS normaDS;
    private final AnexoFactory anexoFactory;

    @Override
    public void remover(Integer id) {
        var optNormaDM = normaDS.buscarNormaPorId(id);
        if(optNormaDM.isEmpty())
            throw new RegistroNaoEncontradoException("Norma não encontrada.");
        normaDS.delete(id);
    }
}
