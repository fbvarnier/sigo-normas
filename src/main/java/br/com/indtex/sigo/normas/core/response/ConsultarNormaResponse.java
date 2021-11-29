package br.com.indtex.sigo.normas.core.response;

import br.com.indtex.sigo.normas.core.entity.Anexo;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ConsultarNormaResponse extends DefaultResponse {

    private Data data;

    @Getter
    public class Data {
        private Integer id;
        private String codigo;
        private String nome;
        private String descricao;
        private String area;
        private String tipo;
        private List<Anexo> anexos;
    }

    public ConsultarNormaResponse(Integer id, String codigo, String nome, String descricao, String area, String tipo, List<Anexo> anexos){
        this.add(id, codigo, nome, descricao, area, tipo, anexos);
    }

    public void add(Integer id, String codigo, String nome, String descricao, String area, String tipo, List<Anexo> anexos){
        var dados = new Data();
        dados.id = id;
        dados.codigo = codigo;
        dados.nome = nome;
        dados.descricao = descricao;
        dados.area = area;
        dados.tipo = tipo;
        dados.anexos = anexos;
        this.data = dados;
    }
}
