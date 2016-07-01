package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import app.models.Cliente;
import app.repository.ClienteRepository;

@RestController
public class ClienteController {

	@Autowired
	private ClienteRepository repository;
	
	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Cliente>>findAll() {
		Iterable<Cliente> clientes = repository.findAll();
        if(clientes == null){
            return new ResponseEntity<Iterable<Cliente>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Iterable<Cliente>>(clientes, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/clientes/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> getCliente(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        Cliente cliente = repository.findById(id);
        if (cliente == null) {
            System.out.println("Cliente with id " + id + " not found");
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }
		
	@RequestMapping(value = "/clientes/salvar", method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody Cliente cliente,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating mcliente " + cliente.getNome());
 
//        if (userService.isUserExist(user)) {
//            System.out.println("A User with name " + user.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
 
        repository.save(cliente);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(cliente.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
	
	@RequestMapping(value = "/clientes/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Cliente> Alterar(@PathVariable("id") long id, @RequestBody Cliente cliente) {
        System.out.println("Atualizando cliente " + id);
         
        Cliente currentCliente = repository.findById(id);
         
        if (currentCliente==null) {
            System.out.println("Cliente with id " + id + " not found");
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }
 
        currentCliente.setNome(cliente.getNome());
        currentCliente.setCpfCnpj(cliente.getCpfCnpj());
        currentCliente.setEndereco(cliente.getEndereco());
        currentCliente.setBairro(cliente.getBairro());
        currentCliente.setCidade(cliente.getCidade());
        currentCliente.setEstado(cliente.getEstado());
        currentCliente.setEmail(cliente.getEmail());
        currentCliente.setTelefone(cliente.getTelefone());
        currentCliente.setCelular(cliente.getCelular());
        currentCliente.setObs(cliente.getObs());
        
                 
        repository.save(currentCliente);
        return new ResponseEntity<Cliente>(currentCliente, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/clientes/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Cliente> delete(@PathVariable("id") long id) {
        
        Cliente cliente = repository.findById(id);
        if (cliente == null) {
            System.out.println("Não foi possivel deletar " + id + " not found");
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }
 
        repository.delete(id);
        return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
    }
}
