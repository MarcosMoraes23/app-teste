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

import app.models.OrdemServico;
import app.repository.OrdemServicoRepository;

@RestController
public class OrdemServicoController {
	@Autowired
	private OrdemServicoRepository repository;
	
	@RequestMapping(value = "/ordensServico", method = RequestMethod.GET)
    public ResponseEntity<Iterable<OrdemServico>>findAll() {
		Iterable<OrdemServico> ordensServico = repository.findAll();
        if(ordensServico == null){
            return new ResponseEntity<Iterable<OrdemServico>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Iterable<OrdemServico>>(ordensServico, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/ordensServico/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrdemServico> getOrdemServico(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        OrdemServico ordemServico = repository.findById(id);
        if (ordemServico == null) {
            System.out.println("OrdemServico with id " + id + " not found");
            return new ResponseEntity<OrdemServico>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<OrdemServico>(ordemServico, HttpStatus.OK);
    }
		
	@RequestMapping(value = "/ordensServico/salvar", method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody OrdemServico ordemServico,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating ordemServico " + ordemServico.getNumero());
 
//        if (userService.isUserExist(user)) {
//            System.out.println("A User with name " + user.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
 
        repository.save(ordemServico);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/ordensServico/{id}").buildAndExpand(ordemServico.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
	
	@RequestMapping(value = "/ordensServico/{id}", method = RequestMethod.PUT)
    public ResponseEntity<OrdemServico> Alterar(@PathVariable("id") long id, @RequestBody OrdemServico ordemServico) {
        System.out.println("Atualizando ordemServico " + id);
         
        OrdemServico currentOrdemServico = repository.findById(id);
         
        if (currentOrdemServico==null) {
            System.out.println("OrdemServico with id " + id + " not found");
            return new ResponseEntity<OrdemServico>(HttpStatus.NOT_FOUND);
        }
 
        currentOrdemServico.setNumero(ordemServico.getNumero());
        currentOrdemServico.setDataEntrada(ordemServico.getDataEntrada());
        currentOrdemServico.setDataSaida(ordemServico.getDataSaida());
        currentOrdemServico.setStatus(ordemServico.getStatus());
        currentOrdemServico.setTipo(ordemServico.getTipo());
        currentOrdemServico.setHistorico(ordemServico.getHistorico());
        currentOrdemServico.setDefeito(ordemServico.getDefeito());
        
        currentOrdemServico.setId_cliente(ordemServico.getId_cliente());
        currentOrdemServico.setId_equipamento(ordemServico.getId_equipamento());
        currentOrdemServico.setId_usuario(ordemServico.getId_usuario());
        
                 
        repository.save(currentOrdemServico);
        return new ResponseEntity<OrdemServico>(currentOrdemServico, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/ordensServico/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<OrdemServico> delete(@PathVariable("id") long id) {
        
        OrdemServico ordemServico = repository.findById(id);
        if (ordemServico == null) {
            System.out.println("Não foi possivel deletar " + id + " not found");
            return new ResponseEntity<OrdemServico>(HttpStatus.NOT_FOUND);
        }
 
        repository.delete(id);
        return new ResponseEntity<OrdemServico>(HttpStatus.NO_CONTENT);
    }
}
