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

import app.models.Usuario;
import app.repository.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Usuario>>findAll() {
		Iterable<Usuario> usuarios = repository.findAll();
        if(usuarios == null){
            return new ResponseEntity<Iterable<Usuario>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Iterable<Usuario>>(usuarios, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/usuarios/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> getUsuario(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        Usuario usuario = repository.findById(id);
        if (usuario == null) {
            System.out.println("Usuario with id " + id + " not found");
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }
		
	@RequestMapping(value = "/usuarios/salvar", method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody Usuario usuario,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating musuario " + usuario.getNome());
 
//        if (userService.isUserExist(user)) {
//            System.out.println("A User with name " + user.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
 
        repository.save(usuario);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(usuario.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
	
	@RequestMapping(value = "/usuarios/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Usuario> Alterar(@PathVariable("id") long id, @RequestBody Usuario usuario) {
        System.out.println("Atualizando usuario " + id);
         
        Usuario currentUsuario = repository.findById(id);
         
        if (currentUsuario==null) {
            System.out.println("Usuario with id " + id + " not found");
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
 
        currentUsuario.setNome(usuario.getNome());
        currentUsuario.setCpf(usuario.getCpf());
        currentUsuario.setEndereco(usuario.getEndereco());
        currentUsuario.setBairro(usuario.getBairro());
        currentUsuario.setCidade(usuario.getCidade());
        currentUsuario.setEstado(usuario.getEstado());
        currentUsuario.setEmail(usuario.getEmail());
        currentUsuario.setTelefone(usuario.getTelefone());
        currentUsuario.setSenha(usuario.getSenha());
        currentUsuario.setStatus(usuario.getStatus());
        currentUsuario.setTipo(usuario.getTipo());
                 
        repository.save(currentUsuario);
        return new ResponseEntity<Usuario>(currentUsuario, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/usuarios/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Usuario> delete(@PathVariable("id") long id) {
        
        Usuario usuario = repository.findById(id);
        if (usuario == null) {
            System.out.println("Não foi possivel deletar " + id + " not found");
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
 
        repository.delete(id);
        return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
    }
}
