package br.com.indtex.sigo.normas.core.usecase.interfaces;

import br.com.indtex.sigo.normas.core.response.UploadResponse;
import org.springframework.web.multipart.MultipartFile;

public interface UploadNovoArquivoInput {

    UploadResponse upload(MultipartFile file);
}
