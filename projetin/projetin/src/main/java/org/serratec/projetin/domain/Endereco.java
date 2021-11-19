package org.serratec.projetin.domain;

/*import java.util.Objects;*/

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Embeddable
public class Endereco {
	
	@NotBlank(message = "Por favor, preencha os dados.")
	@Column
	private String rua;
	
	@NotBlank(message = "Por favor, preencha os dados.")
	@Column
	private String bairro;
	
	@NotBlank(message = "Por favor, preencha os dados.")
	@Size(max = 11, message = "Não é permitido um CEP com mais de {max} dígitos.")
	@Column
	private String cep;
	
	public Endereco() {
		
	}
	
	public Endereco(String rua, String bairro, String cep) {
		super();
		this.rua = rua;
		this.bairro = bairro;
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}

}
