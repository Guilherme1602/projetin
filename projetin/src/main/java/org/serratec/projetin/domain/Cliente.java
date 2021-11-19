package org.serratec.projetin.domain;


import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente", nullable = false)
	private long id;
	
	@NotBlank
	@Size(max=50, min=2, message = "O número de caractéres não pode exceder {max} dígitos")
	@Column(name = "nome")
	private String nome;
	
	@Size(max=50, min=2, message = "O número de caractéres não pode exceder {max} dígitos")
	@Column(name = "sobrenome")
	private String sobrenome;
	
	@NotBlank
	@Size(max=11, message = "O número de caractéres não pode exceder {max} dígitos")
	@Column(name = "cpf", unique = true)
	private String cpf;
	
	@NotBlank
	@Email
	@Column(name= "email")
	private String email;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column
	private LocalDate dataNascimento;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;
	
	public Cliente() {
		super();
	}
	
	public Cliente(long id, String nome, String cpf, String email,
			LocalDate dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	//Incluído
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(LocalDate data) {
		this.dataNascimento = data;
	}
	//Incluído com sucesso
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;	
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, dataNascimento, email, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf) && id == other.id && Objects.equals(nome, other.nome);
	}

}
