package br.com.indtex.sigo.normas.gateway.database;

import br.com.indtex.sigo.normas.core.entity.Norma;
import br.com.indtex.sigo.normas.gateway.database.model.NormaDataModel;

import java.util.List;
import java.util.Optional;

public interface NormaDS {

    Optional<NormaDataModel> buscarNormaPorId(Integer id);
    Optional<NormaDataModel> buscarNormaPorCodigo(String codigo);
    List<NormaDataModel> buscarNormasPorNomeLike(String nome);
    List<NormaDataModel> buscarTodasAsNormas();
    NormaDataModel save(Integer id, Norma norma);
    void delete(Integer id);

}
