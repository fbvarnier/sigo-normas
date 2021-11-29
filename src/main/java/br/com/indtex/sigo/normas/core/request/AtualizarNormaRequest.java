package br.com.indtex.sigo.normas.core.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AtualizarNormaRequest extends DefaultNormaRequest {

    private Integer id;
}
