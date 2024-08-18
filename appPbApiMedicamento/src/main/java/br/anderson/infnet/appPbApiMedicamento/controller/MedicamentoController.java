package br.anderson.infnet.appPbApiMedicamento.controller;

import br.anderson.infnet.appPbApiMedicamento.model.domain.Medicamento;
import br.anderson.infnet.appPbApiMedicamento.service.MedicamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/")
public class MedicamentoController {
    @Autowired
    private MedicamentoService medicamentoService;

    @GetMapping(value = "")
    @Operation(summary = "Lista todos os medicamentos cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de medicamentos",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Medicamento.class))}
            )
    })
    public Iterable<Medicamento> getLista() {
        return medicamentoService.obterLista();
    }

    @Operation(summary = "Obtem dados do medicamento requerido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medicamento encontrado na base",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Medicamento.class))}
            )
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Medicamento>> getProduto(@PathVariable int id) {
        Optional<Medicamento> lTmp;
        lTmp = medicamentoService.ler(id);
        if (lTmp.isEmpty()) {
            return new ResponseEntity<Optional<Medicamento>>(lTmp, HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<Optional<Medicamento>>(lTmp, HttpStatus.OK);
        }
    }

    @Operation(summary = "Deleta um medicamento da lista de medicamentos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deletado com sucesso.")
    })
    @DeleteMapping(value = "/{id}")
    public boolean deletarProduto(@PathVariable int id) {
        medicamentoService.excluir(id);
        return true;
    }

    @PutMapping("")
    @Operation(summary = "Altera um medicamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medicamento",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Medicamento.class))}
            )
    })
    ResponseEntity<Optional<Medicamento>> setProduto(@RequestBody Medicamento medicamento) {
        Optional<Medicamento> lTmp;
        lTmp = medicamentoService.ler(medicamento.getId());
        if (lTmp.isEmpty()) {
            return new ResponseEntity<Optional<Medicamento>>(lTmp, HttpStatus.NOT_FOUND);
        }
        else {
            lTmp = Optional.ofNullable(medicamentoService.salvar(medicamento));
            return new ResponseEntity<Optional<Medicamento>>(lTmp, HttpStatus.OK);
        }
    }

    @PostMapping("")
    @Operation(summary = "Cadastra um novo medicamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medicamento",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Medicamento.class))}
            )
    })
    Medicamento novoProduto(@RequestBody Medicamento medicamento) {
        medicamentoService.incluir(medicamento);
        return medicamento;
    }
}
