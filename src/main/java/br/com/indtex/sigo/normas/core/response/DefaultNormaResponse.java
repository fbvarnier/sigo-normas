package br.com.indtex.sigo.normas.core.response;

import br.com.indtex.sigo.normas.core.entity.Anexo;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DefaultNormaResponse extends DefaultResponse {

    private Data data;

    @Getter
    public class Data {
        private String codigo;
        private String nome;
        private String descricao;
        private String area;
        private String tipo;
        private List<Anexo> anexos;
    }

    public void add(String codigo, String nome, String descricao, String area, String tipo, List<Anexo> anexos){
        var dados = new Data();
        dados.codigo = codigo;
        dados.nome = nome;
        dados.descricao = descricao;
        dados.area = area;
        dados.tipo = tipo;
        dados.anexos = anexos;
        this.data = dados;
    }
}
