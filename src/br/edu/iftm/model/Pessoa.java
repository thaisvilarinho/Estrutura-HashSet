package br.edu.iftm.model;

public class Pessoa {

	private int id;
	private String nome;
	private String numero;
	private String endereco;
	private String email;
	private static int contador = 0;

	public Pessoa(String nome, String numero, String endereco, String email){
		Pessoa.contador++;
		this.nome = nome;
	    this.numero = numero;
	    this.endereco = endereco;
	    this.email = email;
	    this.id = Pessoa.contador;
	}
	
	public Pessoa(String nome, String numero) {
		Pessoa.contador++;
		this.nome = nome;
		this.numero = numero;
	    this.id = Pessoa.contador;
	}
	 


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "\nId="+ id + "\nNome=" + nome + "\nNumero=" + numero + "\nEndereco=" + endereco + "\nE-mail=" + email+"\n\n";
	}

	

}
