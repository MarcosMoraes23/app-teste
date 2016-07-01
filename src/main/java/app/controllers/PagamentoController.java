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

import app.models.Pagamento;
import app.repository.PagamentoRepository;

@RestController
public class PagamentoController {

	@Autowired
	private PagamentoRepository repository;
	
	@RequestMapping(value = "/pagamentos", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Pagamento>>findAll() {
		Iterable<Pagamento> pagamentos = repository.findAll();
        if(pagamentos == null){
            return new ResponseEntity<Iterable<Pagamento>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Iterable<Pagamento>>(pagamentos, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/pagamentos/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pagamento> getPagamento(@PathVariable("id") long id) {
        System.out.println("Fetching Pagamento with id " + id);
        Pagamento pagamento = repository.findById(id);
        if (pagamento == null) {
            System.out.println("Pagamento with id " + id + " not found");
            return new ResponseEntity<Pagamento>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Pagamento>(pagamento, HttpStatus.OK);
    }
		
	@RequestMapping(value = "/pagamentos/salvar", method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody Pagamento pagamento,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating mpagamento " + pagamento.getDescricaoPgto());
 
//        if (userService.isUserExist(user)) {
//            System.out.println("A User with name " + user.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
 
        repository.save(pagamento);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/pagamentos/{id}").buildAndExpand(pagamento.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
	
	@RequestMapping(value = "/pagamentos/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Pagamento> Alterar(@PathVariable("id") long id, @RequestBody Pagamento pagamento) {
        System.out.println("Atualizando pagamento " + id);
         
        Pagamento currentPagamento = repository.findById(id);
         
        if (currentPagamento==null) {
            System.out.println("Pagamento with id " + id + " not found");
            return new ResponseEntity<Pagamento>(HttpStatus.NOT_FOUND);
        }
 
        currentPagamento.setDescricaoPgto(pagamento.getDescricaoPgto());
        currentPagamento.setDataPgto(pagamento.getDataPgto());
        currentPagamento.setValor(pagamento.getValor());
        
        currentPagamento.setFormaPgto(pagamento.getFormaPgto());
        currentPagamento.setOrdemServico(pagamento.getOrdemServico());
        
        
        repository.save(currentPagamento);
        return new ResponseEntity<Pagamento>(currentPagamento, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/pagamentos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Pagamento> delete(@PathVariable("id") long id) {
        
        Pagamento pagamento = repository.findById(id);
        if (pagamento == null) {
            System.out.println("Não foi possivel deletar " + id + " not found");
            return new ResponseEntity<Pagamento>(HttpStatus.NOT_FOUND);
        }
 
        repository.delete(id);
        return new ResponseEntity<Pagamento>(HttpStatus.NO_CONTENT);
    }
}
