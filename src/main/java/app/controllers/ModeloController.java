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

import app.models.Modelo;
import app.repository.ModeloRepository;


@RestController
public class ModeloController {
	
	@Autowired
	private ModeloRepository repository;
	
	

	@RequestMapping(value = "/modelos", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Modelo>>findAll() {
		Iterable<Modelo> modelos = repository.findAll();
        if(modelos == null){
            return new ResponseEntity<Iterable<Modelo>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Iterable<Modelo>>(modelos, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/modelos/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Modelo> getModelo(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        Modelo modelo = repository.findById(id);
        if (modelo == null) {
            System.out.println("Modelo with id " + id + " not found");
            return new ResponseEntity<Modelo>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Modelo>(modelo, HttpStatus.OK);
    }
		
	@RequestMapping(value = "/modelos/salvar", method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody Modelo modelo,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating mmodelo " + modelo.getDescricao());
 
//        if (userService.isUserExist(user)) {
//            System.out.println("A User with name " + user.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
 
        repository.save(modelo);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(modelo.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
	
	@RequestMapping(value = "/modelos/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Modelo> Alterar(@PathVariable("id") long id, @RequestBody Modelo modelo) {
        System.out.println("Atualizando modelo " + id);
         
        Modelo currentModelo = repository.findById(id);
         
        if (currentModelo==null) {
            System.out.println("Modelo with id " + id + " not found");
            return new ResponseEntity<Modelo>(HttpStatus.NOT_FOUND);
        }
 
        currentModelo.setDescricao(modelo.getDescricao());
        currentModelo.setMarca(modelo.getMarca());
                 
        repository.save(currentModelo);
        return new ResponseEntity<Modelo>(currentModelo, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/modelos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Modelo> delete(@PathVariable("id") long id) {
        
        Modelo modelo = repository.findById(id);
        if (modelo == null) {
            System.out.println("Não foi possivel deletar " + id + " not found");
            return new ResponseEntity<Modelo>(HttpStatus.NOT_FOUND);
        }
 
        repository.delete(id);
        return new ResponseEntity<Modelo>(HttpStatus.NO_CONTENT);
    }
	
	
}
