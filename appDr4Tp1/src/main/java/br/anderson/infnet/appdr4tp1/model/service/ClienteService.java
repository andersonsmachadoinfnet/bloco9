package br.anderson.infnet.appdr4tp1.model.service;

import br.anderson.infnet.appdr4tp1.model.domain.Cliente;
import br.anderson.infnet.appdr4tp1.model.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository _rps;

    public ClienteService(ClienteRepository clienteRepository) {
        this._rps = clienteRepository;
    }

    public Cliente incluir(Cliente itm) {
        return _rps.save(itm);
    }

    public Optional<Cliente> buscarPorId(Integer id) {
        return _rps.findById(id);
    }

    public Cliente alterar(Integer id, Cliente itm) {
        Cliente _itm = _rps.getReferenceById(id);
        return _rps.save(_itm.assign(itm));
    }

    public Collection<Cliente> obterLista() {
        return _rps.findAll();
    }

    public void excluir(Integer id) {
        _rps.deleteById(id);
    }

}
