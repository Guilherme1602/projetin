package org.serratec.projetin.domain;

import java.util.Objects;

/*import java.util.Objects;*/

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco", nullable = false)
	private long id;
	
	@NotBlank(message = "Por favor, preencha os dados.")
	@Column
	private String rua;
	
	@NotBlank(message = "Por favor, preencha os dados.")
	@Column
	private String bairro;
	
	@NotBlank(message = "Por favor, preencha os dados.")
	//TODO Colocar o CEP
	@Size(max = 8, message = "Não é permitido um CEP com mais de {max} dígitos.")
	@Column
	private String cep;
	
	@OneToOne(mappedBy = "endereco")
	private Cliente cliente;
	
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

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, id, rua);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep) && id == other.id
				&& Objects.equals(rua, other.rua);
	}

}
