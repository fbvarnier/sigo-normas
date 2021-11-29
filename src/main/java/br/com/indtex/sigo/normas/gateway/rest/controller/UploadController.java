package br.com.indtex.sigo.normas.gateway.rest.controller;

import br.com.indtex.sigo.normas.core.response.UploadResponse;
import br.com.indtex.sigo.normas.core.usecase.interfaces.UploadNovoArquivoInput;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
@AllArgsConstructor
public class UploadController {

    private final UploadNovoArquivoInput uploadNovoArquivoInput;

    @PutMapping("/")
    public ResponseEntity<UploadResponse> uploadFile(@RequestParam MultipartFile file) {
        var resposta = uploadNovoArquivoInput.upload(file);
        return ResponseEntity.ok(resposta);
    }
}
