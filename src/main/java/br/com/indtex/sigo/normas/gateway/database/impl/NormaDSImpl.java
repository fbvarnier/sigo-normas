package br.com.indtex.sigo.normas.gateway.database.impl;

import br.com.indtex.sigo.normas.core.entity.Norma;
import br.com.indtex.sigo.normas.gateway.database.NormaDS;
import br.com.indtex.sigo.normas.gateway.database.model.AnexoDataModel;
import br.com.indtex.sigo.normas.gateway.database.model.NormaDataModel;
import br.com.indtex.sigo.normas.gateway.database.repository.NormaRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class NormaDSImpl implements NormaDS {

    private NormaRespository respository;

    @Override
    public Optional<NormaDataModel> buscarNormaPorId(Integer id) {
        return respository.findById(id);
    }

    @Override
    public Optional<NormaDataModel> buscarNormaPorCodigo(String codigo) {
        return respository.findByCodigo(codigo);
    }

    @Override
    public List<NormaDataModel> buscarNormasPorNomeLike(String nome) {
        return respository.findByNomeLike(nome);
    }

    @Override
    public List<NormaDataModel> buscarTodasAsNormas() {
        return respository.findAll();
    }

    @Override
    public NormaDataModel save(Integer id, Norma norma) {
        var normaDM = new NormaDataModel(id,
                norma.getCodigo(),
                norma.getNome(),
                norma.getDescricao(),
                norma.getArea(),
                norma.getTipo().name(),
                LocalDate.now(),
                LocalDateTime.now());
        var anexosList = norma.getAnexos()
                .stream()
                .map(anexo -> new AnexoDataModel(anexo.getId(), anexo.getNome(), anexo.getTipo(), anexo.getLink(), normaDM))
                .collect(Collectors.toList());
        normaDM.setAnexos(anexosList);
        return respository.save(normaDM);
    }

    @Override
    public void delete(Integer id) {
        respository.deleteById(id);
    }

}
