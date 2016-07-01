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

import app.models.Equipamento;
import app.repository.EquipamentoRepository;

@RestController
public class EquipamentoController {

	@Autowired
	private EquipamentoRepository repository;
	
	@RequestMapping(value = "/equipamentos", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Equipamento>>findAll() {
		Iterable<Equipamento> equipamentos = repository.findAll();
        if(equipamentos == null){
            return new ResponseEntity<Iterable<Equipamento>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Iterable<Equipamento>>(equipamentos, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/equipamentos/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Equipamento> getEquipamento(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        Equipamento equipamento = repository.findById(id);
        if (equipamento == null) {
            System.out.println("Equipamento with id " + id + " not found");
            return new ResponseEntity<Equipamento>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Equipamento>(equipamento, HttpStatus.OK);
    }
		
	@RequestMapping(value = "/equipamentos/salvar", method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody Equipamento equipamento,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating mequipamento " + equipamento.getEquipamento());
 
//        if (userService.isUserExist(user)) {
//            System.out.println("A User with name " + user.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
 
        repository.save(equipamento);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(equipamento.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
	
	@RequestMapping(value = "/equipamentos/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Equipamento> Alterar(@PathVariable("id") long id, @RequestBody Equipamento equipamento) {
        System.out.println("Atualizando equipamento " + id);
         
        Equipamento currentEquipamento = repository.findById(id);
         
        if (currentEquipamento==null) {
            System.out.println("Equipamento with id " + id + " not found");
            return new ResponseEntity<Equipamento>(HttpStatus.NOT_FOUND);
        }
 
        currentEquipamento.setEquipamento(equipamento.getEquipamento());
        currentEquipamento.setAcessorios(equipamento.getAcessorios());
        currentEquipamento.setNumeroSerie(equipamento.getNumeroSerie());
        currentEquipamento.setObs(equipamento.getObs());
        
        currentEquipamento.setModelo(equipamento.getModelo());
        
                 
        repository.save(currentEquipamento);
        return new ResponseEntity<Equipamento>(currentEquipamento, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/equipamentos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Equipamento> delete(@PathVariable("id") long id) {
        
        Equipamento equipamento = repository.findById(id);
        if (equipamento == null) {
            System.out.println("Não foi possivel deletar " + id + " not found");
            return new ResponseEntity<Equipamento>(HttpStatus.NOT_FOUND);
        }
 
        repository.delete(id);
        return new ResponseEntity<Equipamento>(HttpStatus.NO_CONTENT);
    }
}
