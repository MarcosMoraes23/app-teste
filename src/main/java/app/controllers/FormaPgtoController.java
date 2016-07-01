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

import app.models.FormaPgto;
import app.repository.FormaPgtoRepository;

@RestController
public class FormaPgtoController {

	@Autowired
	private FormaPgtoRepository repository;
	
	@RequestMapping(value = "/formaspgto", method = RequestMethod.GET)
    public ResponseEntity<Iterable<FormaPgto>>findAll() {
		Iterable<FormaPgto> formasPgto = repository.findAll();
        if(formasPgto == null){
            return new ResponseEntity<Iterable<FormaPgto>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Iterable<FormaPgto>>(formasPgto, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/formaspgto/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FormaPgto> getFormaPgto(@PathVariable("id") long id) {
        System.out.println("Fetching FormaPgto with id " + id);
        FormaPgto formaPgto = repository.findById(id);
        if (formaPgto == null) {
            System.out.println("Formapgto with id " + id + " not found");
            return new ResponseEntity<FormaPgto>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FormaPgto>(formaPgto, HttpStatus.OK);
    }
		
	@RequestMapping(value = "/formaspgto", method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody FormaPgto formaPgto,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating pgto " + formaPgto.getDescricao());
 
//        if (userService.isUserExist(user)) {
//            System.out.println("A User with name " + user.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
 
        repository.save(formaPgto);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(formaPgto.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
	
	@RequestMapping(value = "/formaspgto/{id}", method = RequestMethod.PUT)
    public ResponseEntity<FormaPgto> Alterar(@PathVariable("id") long id, @RequestBody FormaPgto formaPgto) {
        System.out.println("Atualizando formasPgto " + id);
         
        FormaPgto currentFormaPgto = repository.findById(id);
         
        if (currentFormaPgto==null) {
            System.out.println("FormaPgto with id " + id + " not found");
            return new ResponseEntity<FormaPgto>(HttpStatus.NOT_FOUND);
        }
 
        currentFormaPgto.setDescricao(formaPgto.getDescricao());
        currentFormaPgto.setObs(formaPgto.getObs());
        
                 
        repository.save(currentFormaPgto);
        return new ResponseEntity<FormaPgto>(currentFormaPgto, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/formaspgto/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<FormaPgto> delete(@PathVariable("id") long id) {
        
        FormaPgto formaPgto = repository.findById(id);
        if (formaPgto == null) {
            System.out.println("Não foi possivel deletar " + id + " not found");
            return new ResponseEntity<FormaPgto>(HttpStatus.NOT_FOUND);
        }
 
        repository.delete(id);
        return new ResponseEntity<FormaPgto>(HttpStatus.NO_CONTENT);
    }
}
