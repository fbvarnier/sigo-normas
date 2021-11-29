package br.com.indtex.sigo.normas.core.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class DefaultNormaRequest {

    private String codigo;
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotBlank
    private String area;
    private String tipo;
    private List<AnexoRequest> anexos;

    @Getter
    @Setter
    public class AnexoRequest{
        private long id;
        private String nome;
        private String tipo;
        private String link;
    }
}
