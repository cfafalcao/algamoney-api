package com.algaworks.algamoney.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algamoney.api.event.RecursoCriadoEvent;
import com.algaworks.algamoney.api.model.Categoria;
import com.algaworks.algamoney.api.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaRepository cr;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Categoria> listar(){
		return cr.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
		Categoria categoriaSalva = cr.save(categoria);
		
		//atravez da classe ServletUriComponentsBuilder vou pegar a partir da requizição atual
		//fromCurrentRequestUri adicionar o {codigo} e adicionar esse codigo na uri
		//getCodigo()).toUri()
//substituir
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
//				.buildAndExpand(categoriaSalva.getCodigo()).toUri();
//		//setar o Header Locacion com essa uri
//		//retorna Location > localhost:8080/categorias/11
//		response.setHeader("Location", uri.toASCIIString());
		publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
		//retorna o status da uri de categoriaSalva 201 Created
		//return ResponseEntity.created(uri).body(categoriaSalva);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo) {
		Categoria categoria = cr.findByCodigo(codigo);
		//caso a categoria existir responde 200 Ok, senão 404 Not Found
		return categoria !=null ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
	}
	
}