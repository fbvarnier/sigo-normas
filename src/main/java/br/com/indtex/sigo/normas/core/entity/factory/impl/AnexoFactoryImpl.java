package br.com.indtex.sigo.normas.core.entity.factory.impl;

import br.com.indtex.sigo.normas.core.entity.Anexo;
import br.com.indtex.sigo.normas.core.entity.factory.AnexoFactory;
import br.com.indtex.sigo.normas.core.entity.impl.AnexoImpl;
import org.springframework.stereotype.Component;

@Component
public class AnexoFactoryImpl implements AnexoFactory {

    @Override
    public Anexo criar(long id, String nome, String tipo, String link) {
        return new AnexoImpl(id, nome, tipo, link);
    }
}
