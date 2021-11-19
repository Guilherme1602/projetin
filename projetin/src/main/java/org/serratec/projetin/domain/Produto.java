package org.serratec.projetin.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Produto {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_produto")
	private long id;
	
	@NotBlank
	@Column
	private String nome;
	
	@NotBlank
	@Column
	private String descricao;
	
	@Column
	private double valorUnitario;
	
	@Column
	private int estoque;
	
	//Construtor
	public Produto() {
		super();
	}
	
	public Produto(long id, String nome, String descricao, double valorUnitario, int estoque) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.valorUnitario = valorUnitario;
		this.estoque = estoque;
	}
	//Métodos
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	public double getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	//HashCode e Equals

	@Override
	public int hashCode() {
		return Objects.hash(descricao, estoque, id, nome, valorUnitario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(descricao, other.descricao) && estoque == other.estoque && id == other.id
				&& Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(valorUnitario) == Double.doubleToLongBits(other.valorUnitario);
	}

}
