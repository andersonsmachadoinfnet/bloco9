package br.anderson.infnet.appPbApiReceitaMedica.controller;

import br.anderson.infnet.appPbApiReceitaMedica.model.domain.ReceitaMedica;
import br.anderson.infnet.appPbApiReceitaMedica.model.domain.RegistroReceita;
import br.anderson.infnet.appPbApiReceitaMedica.service.ReceitaMedicaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ReceitaMedicaController {
    @Autowired
    private ReceitaMedicaService _sc;

    @GetMapping(value = "")
    @Operation(summary = "Lista todas as receitas médicas cadastradas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de receitas",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ReceitaMedica.class))}
            )
    })
    public Iterable<ReceitaMedica> getReceitaMedica() {
        return _sc.obterLista();
    }

    @PutMapping(value = "")
    @Operation(summary = "Registra uma receita no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Receita registrada",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ReceitaMedica.class))}
            )
    })
    ReceitaMedica setRegistra(@RequestBody RegistroReceita itm) {
        return _sc.registraReceita(itm);
    }
/*
    @PutMapping(value = "")
    @Operation(summary = "Altera ou registra uma receita")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medicamento",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ReceitaMedica.class))}
            )
    })
    ReceitaMedica setReceitaMedica(@RequestBody ReceitaMedica itm) {
        return _sc.incluir(itm);
    }
*/
}
