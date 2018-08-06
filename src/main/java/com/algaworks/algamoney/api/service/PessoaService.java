package com.algaworks.algamoney.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algamoney.api.model.Pessoa;
import com.algaworks.algamoney.api.repository.PessoaRepository;

@Service  //um componente do spring, vamos poder utiliza-la, injeta-la quando precisar
public class PessoaService {
	
	@Autowired
	private PessoaRepository pr;
	
	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);
		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
		return pr.save(pessoaSalva);
		
	}

	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		//buscar pessoa salva, ja temos em atualizar, então para não duplicar o código
		//marcar parte do método desejado, clicar com botão direito / Refactor / Extract Method
		Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);
		pessoaSalva.setAtivo(ativo);
		pr.save(pessoaSalva);
	}

	public Pessoa buscarPessoaPeloCodigo(Long codigo) {
		//copiar a regra que está em PessoaResource
		Pessoa pessoaSalva = pr.findOne(codigo);
		//trata caso digite um código que não existe e espera que em AlgamoneyExceptionHandler retorne
		//recurso.nao-encontrado NOT_FOUND no @ExceptionHandler
		if (pessoaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoaSalva;
	}


}
