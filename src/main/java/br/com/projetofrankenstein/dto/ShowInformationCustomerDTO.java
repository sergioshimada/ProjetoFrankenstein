package br.com.projetofrankenstein.dto;

import java.io.Serializable;

public class ShowInformationCustomerDTO implements Serializable {

	private static final long serialVersionUID = 6527147684663582400L;

	private long id;
	private String name;
	private Long cpf;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

}
