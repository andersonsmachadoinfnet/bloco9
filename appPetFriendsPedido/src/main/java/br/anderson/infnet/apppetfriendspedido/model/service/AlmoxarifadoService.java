package br.anderson.infnet.apppetfriendspedido.model.service;

import br.anderson.infnet.apppetfriendspedido.model.domain.infra.EventoClienteComprou;
import org.springframework.stereotype.Service;

@Service
public class AlmoxarifadoService {
    public void SeparaPedido(EventoClienteComprou evento) {
        System.out.println("Separa pedido---> " + evento);
    }
}
