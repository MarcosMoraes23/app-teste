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

import app.models.Servico;
import app.repository.ServicoRepository;


@RestController
public class ServicoController {

	@Autowired
	private ServicoRepository repository;
	
	@RequestMapping(value = "/servicos", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Servico>>findAll() {
		Iterable<Servico> servicos = repository.findAll();
        if(servicos == null){
            return new ResponseEntity<Iterable<Servico>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Iterable<Servico>>(servicos, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/servicos/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Servico> getServico(@PathVariable("id") long id) {
        System.out.println("Fetching Serviço with id " + id);
        Servico servico = repository.findById(id);
        if (servico == null) {
            System.out.println("Servico with id " + id + " not found");
            return new ResponseEntity<Servico>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Servico>(servico, HttpStatus.OK);
    }
		
	@RequestMapping(value = "/servicos", method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody Servico servico,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating servico " + servico.getDescricao());
 
//        if (userService.isUserExist(user)) {
//            System.out.println("A User with name " + user.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
 
        repository.save(servico);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(servico.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
	
	@RequestMapping(value = "/servicos/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Servico> Alterar(@PathVariable("id") long id, @RequestBody Servico servico) {
        System.out.println("Atualizando servico " + id);
         
        Servico currentServico = repository.findById(id);
         
        if (currentServico==null) {
            System.out.println("Servico with id " + id + " not found");
            return new ResponseEntity<Servico>(HttpStatus.NOT_FOUND);
        }
 
        currentServico.setDescricao(servico.getDescricao());
        currentServico.setValorServico(servico.getValorServico());
        
                         
        repository.save(currentServico);
        return new ResponseEntity<Servico>(currentServico, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/servicos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Servico> delete(@PathVariable("id") long id) {
        
        Servico servico = repository.findById(id);
        if (servico == null) {
            System.out.println("Não foi possivel deletar " + id + " not found");
            return new ResponseEntity<Servico>(HttpStatus.NOT_FOUND);
        }
 
        repository.delete(id);
        return new ResponseEntity<Servico>(HttpStatus.NO_CONTENT);
    }
  
}
