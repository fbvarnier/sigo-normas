package br.com.indtex.sigo.normas.core.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UploadResponse {

    private boolean sucesso;
    private String link;
}
