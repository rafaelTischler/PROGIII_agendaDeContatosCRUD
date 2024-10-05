package agenda_CRUD;

public class Contato {
	private String nome;
	private String email;
	private String telefone;
	private String tipo;

	public Contato() {

	}

	public Contato(String nome, String email, String telefone, String tipo) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String[] toLinha() {
		return new String[] { this.nome, this.email, this.telefone, this.tipo };
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Contato other = (Contato) obj;
		return nome.equals(other.nome) && email.equals(other.email) && telefone.equals(other.telefone) && tipo.equals(other.tipo);
	}

}
