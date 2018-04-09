package br.com.projetofrankenstein.dto;

public class ShowInformationUserDTO {

	private Long id;
	private String name;

	public ShowInformationUserDTO(Long id,String name) {
		this.id = id;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return name;
		}

	public void setNome(String nome) {
		this.name = nome;
	}
}
