package com.algaworks.algamoney.api.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class RecursoCriadoEvent extends ApplicationEvent{

	private static final long serialVersionUID = 1L;
	
	private HttpServletResponse response;
	private Long codigo;

	//regra pra criar um evento. Quando quizer adicionar um headler location
	//vou precisar criar esse evento passando o HttpServletResponse e o codigo
	public RecursoCriadoEvent(Object source, HttpServletResponse response, Long codigo) {
		super(source);
		this.response = response;
		this.codigo = codigo;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public Long getCodigo() {
		return codigo;
	}

}
