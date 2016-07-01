package app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "usuario")
public class Usuario{
		
		
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private Long id;
	
	@Column(name="cpf", nullable=false, unique=true, length=11)	
	private String cpf;
	
	@Column(name="nome", nullable=false, length=60)	
	private String nome;
	
	@Column(name="endereco", nullable=true, length=255)	
	private String endereco;
	
	@Column(name="bairro", nullable=true, length=120)	
	private String bairro;
	
	@Column(name="cidade", nullable=true, length=60)	
	private String cidade;
	
	@Column(name="estado", nullable=true, length=2)	
	private String estado;
	
	@Column(name="telefone", nullable=false, length=12)	
	private String telefone;
	
	@Column(name="email", nullable=true, length=60)	
	private String email;
	
	@Column(name="tipo", nullable=false, length=1)	
	private char tipo;
	
	@Column(name="senha", nullable=false, length=255)	
	private String senha;
	
	@Column(name="status", nullable=false, length=1)	
	private char status;

	public Usuario() {
	}

	public Usuario(Long id, String cpf, String nome, String endereco,
			String bairro, String cidade, String estado, String telefone,
			String email, char tipo, String senha, char status) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone = telefone;
		this.email = email;
		this.tipo = tipo;
		this.senha = senha;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public char getTipo() {
		return tipo;
	}

	public String getSenha() {
		return senha;
	}

	public char getStatus() {
		return status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", cpf=" + cpf + ", nome=" + nome
				+ ", endereco=" + endereco + ", bairro=" + bairro + ", cidade="
				+ cidade + ", estado=" + estado + ", telefone=" + telefone
				+ ", email=" + email + ", tipo=" + tipo + ", senha=" + senha
				+ ", status=" + status + "]";
	}
	
	
}
