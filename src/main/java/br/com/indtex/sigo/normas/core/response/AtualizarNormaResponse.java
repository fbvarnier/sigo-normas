package br.com.indtex.sigo.normas.core.response;

import br.com.indtex.sigo.normas.core.entity.Anexo;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AtualizarNormaResponse extends DefaultNormaResponse {

    public AtualizarNormaResponse(String codigo, String nome, String descricao, String area, String tipo, List<Anexo> anexos){
        this.add(codigo, nome, descricao, area, tipo, anexos);
    }

}
