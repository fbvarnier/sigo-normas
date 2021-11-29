package br.com.indtex.sigo.normas.gateway.database.repository;

import br.com.indtex.sigo.normas.gateway.database.model.NormaDataModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NormaRespository extends JpaRepository<NormaDataModel, Integer> {

    Optional<NormaDataModel> findByCodigo(String codigo);
    List<NormaDataModel> findByNomeLike(String nome);

}
