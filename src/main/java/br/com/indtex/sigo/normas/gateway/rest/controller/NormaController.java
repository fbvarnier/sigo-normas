package br.com.indtex.sigo.normas.gateway.rest.controller;

import br.com.indtex.sigo.normas.core.request.AdicionarNovaNormaRequest;
import br.com.indtex.sigo.normas.core.request.AtualizarNormaRequest;
import br.com.indtex.sigo.normas.core.response.*;
import br.com.indtex.sigo.normas.core.usecase.interfaces.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Operações de Normas")
@RequiredArgsConstructor
@RestController("/norma")
public class NormaController {

    private final AdicionarNovaNormaInput adicionarNovaNormaInput;
    private final AtualizarNormaInput atualizarNormaInput;
    private final ConsultarNormaPorCodigoInput consultarNormaPorCodigoInput;
    private final ConsultarNormaPorNomeInput consultarNormaPorNomeInput;
    private final RemoverNormaInput removerNormaInput;

    @Operation(summary = "Adiciona uma nova norma.")
    @PutMapping("/add")
    public AdicionarNovaNormaResponse adicionarNovaNorma(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Dados para uma nova norma.", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AdicionarNovaNormaRequest.class)))
            @RequestBody AdicionarNovaNormaRequest request){
        return adicionarNovaNormaInput.adicionar(request);
    }

    @Operation(summary = "Atualizar uma norma existente.")
    @PostMapping("/update")
    public AtualizarNormaResponse atualizarNorma(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Dados para atualização da norma.", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AtualizarNormaRequest.class)))
            @RequestBody AtualizarNormaRequest request){
        return atualizarNormaInput.atualizar(request);
    }

    @Operation(summary = "Remover uma norma existente.")
    @DeleteMapping("/delete/{id}")
    public void removerNorma(@Parameter(description = "Id da norma.") @PathVariable  Integer id){
        removerNormaInput.remover(id);
    }

    @Operation(summary = "Busca uma norma por codigo.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ConsultarNormaResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Se codigo da norma for null.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DefaultResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Se a norma não for encontrada.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DefaultResponse.class))})
    })
    @GetMapping("/buscar/por-codigo/{codigo}")
    public ConsultarNormaResponse consultaNormaPorCodigo(@Parameter(description = "Código da norma.") @PathVariable String codigo) {
        return consultarNormaPorCodigoInput.consultar(codigo);
    }

    @Operation(summary = "Busca uma norma por 'like' do seu nome.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ConsultarNormaResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Se o nome da norma for null.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DefaultResponse.class))})
    })
    @GetMapping("/buscar/por-nome/{nome}")
    public ConsultarNormaResponseList consultaNormaPorNome(@Parameter(description = "Nome da norma.") @PathVariable String nome) {
        return consultarNormaPorNomeInput.consultar(nome);
    }
}
