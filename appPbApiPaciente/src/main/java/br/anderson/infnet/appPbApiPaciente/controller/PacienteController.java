package br.anderson.infnet.appPbApiPaciente.controller;

import br.anderson.infnet.appPbApiPaciente.model.domain.Paciente;
import br.anderson.infnet.appPbApiPaciente.service.PacienteService;
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
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping(value = "")
    @Operation(summary = "Lista todos os pacientes cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de pacientes",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Paciente.class))}
            )
    })
    public Iterable<Paciente> getLista() {
        return pacienteService.obterLista();
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Retorna o paciente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paciente",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Paciente.class))}
            )
    })
    public Optional<Paciente> getPaciente(@PathVariable int id) {
        return pacienteService.ler(id);
    }

    @Operation(summary = "Deleta um paciente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de pacientes",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Paciente.class))}
            )
    })
    @DeleteMapping(value = "/{id}")
    public boolean deletarPaciente(@PathVariable int id) {
        pacienteService.excluir(id);
        return true;
    }

    @PutMapping("")
    @Operation(summary = "Altera o cadastro de um paciente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "paciente",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Paciente.class))}
            )
    })
    ResponseEntity<Optional<Paciente>> setPaciente(@RequestBody Paciente paciente) {
        Optional<Paciente> lTmp;
        lTmp = pacienteService.ler(paciente.getId());
        if (lTmp.isEmpty()) {
            return new ResponseEntity<Optional<Paciente>>(lTmp, HttpStatus.NOT_FOUND);
        }
        else {
            lTmp = Optional.ofNullable(pacienteService.salvar(paciente));
            return new ResponseEntity<Optional<Paciente>>(lTmp, HttpStatus.OK);
        }
    }

    @PostMapping("")
    @Operation(summary = "Cadastra um novo paciente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paciente",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Paciente.class))}
            )
    })
    Paciente novoPaciente(@RequestBody Paciente paciente) {
        pacienteService.incluir(paciente);
        return paciente;
    }
}
