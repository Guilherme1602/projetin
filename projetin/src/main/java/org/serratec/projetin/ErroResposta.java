package org.serratec.projetin;

public class ErroResposta {
	
	private int status;
	private String titulo;
	private String datahora;
	
	public ErroResposta() {
		
	}
	
	public ErroResposta(int status, String titulo, String datahora) {
		super();
		this.status = status;
		this.titulo = titulo;
		this.datahora = datahora;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDatahora() {
		return datahora;
	}

	public void setDatahora(String datahora) {
		this.datahora = datahora;
	}
	
	

}
