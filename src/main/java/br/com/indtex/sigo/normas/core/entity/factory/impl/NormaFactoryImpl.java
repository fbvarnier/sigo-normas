package br.com.indtex.sigo.normas.core.entity.factory.impl;

import br.com.indtex.sigo.normas.core.entity.Anexo;
import br.com.indtex.sigo.normas.core.entity.Norma;
import br.com.indtex.sigo.normas.core.entity.enums.TipoNorma;
import br.com.indtex.sigo.normas.core.entity.factory.AnexoFactory;
import br.com.indtex.sigo.normas.core.entity.factory.NormaFactory;
import br.com.indtex.sigo.normas.core.entity.impl.NormaImpl;
import br.com.indtex.sigo.normas.core.request.DefaultNormaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NormaFactoryImpl implements NormaFactory {

    @Autowired
    private AnexoFactory anexoFactory;

    @Override
    public Norma criar(String codigo, String nome, String descricao, String area, String tipo, List<Anexo> anexos) {
        return new NormaImpl(codigo, nome, descricao, area, TipoNorma.valueOf(tipo), anexos);
    }

    @Override
    public Norma criar(DefaultNormaRequest request) {
        var anexos = request.getAnexos()
                .stream()
                .map(anexoRequest -> anexoFactory.criar(anexoRequest.getId(), anexoRequest.getNome(), anexoRequest.getTipo(), anexoRequest.getLink()))
                .collect(Collectors.toList());
        return this.criar(request.getCodigo(), request.getNome(), request.getDescricao(), request.getArea(), request.getTipo(), anexos);
    }
}
