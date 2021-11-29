package br.com.indtex.sigo.normas.core.usecase;

import br.com.indtex.sigo.normas.core.response.UploadResponse;
import br.com.indtex.sigo.normas.core.usecase.interfaces.UploadNovoArquivoInput;
import br.com.indtex.sigo.normas.gateway.storage.UploadService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@AllArgsConstructor
public class UploadNovoArquivo implements UploadNovoArquivoInput {

    private final UploadService uploadService;

    @Override
    public UploadResponse upload(MultipartFile file) {
        try {
            var nome = file.getOriginalFilename();
            var fileBytes = file.getBytes();
            var resposta = new UploadResponse(true, uploadService.uploadObject(nome, file.getContentType(), fileBytes));
            return resposta;
        } catch (IOException e) {
            throw new RuntimeException("Houve um problema no updaload do arquivo");
        }
    }
}
