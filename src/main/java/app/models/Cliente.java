package app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {
		
		
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false, length=10)
	private Long id;
	
	@Column(name="cpf_cnpj", nullable=false, unique=true, length=14)	
	private String cpfCnpj;
	
	@Column(name="nome", nullable=false, length=60)	
	private String nome;
	
	@Column(name="endereco", nullable=false, length=120)	
	private String endereco;
	
	@Column(name="bairro", nullable=false, length=120)	
	private String bairro;
	
	@Column(name="cidade", nullable=false, length=60)	
	private String cidade;
	
	@Column(name="estado", nullable=false, length=2)	
	private String estado;
	
	@Column(name="telefone", nullable=true, length=12)	
	private String telefone;
	
	@Column(name="celular", nullable=true, length=12)	
	private String celular;
	
	@Column(name="email", nullable=true, length=60)	
	private String email;
	
	@Column(name="obs", nullable=true, length=255)	
	private String obs;

		
	public Cliente() {
	}

	public Cliente(Long id, String cpfCnpj, String nome, String endereco,
			String bairro, String cidade, String estado, String telefone,
			String celular, String email, String obs) {
		this.id = id;
		this.cpfCnpj = cpfCnpj;
		this.nome = nome;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.obs = obs;
	}
	

	public Long getId() {
		return id;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
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

	public String getCelular() {
		return celular;
	}

	public String getEmail() {
		return email;
	}

	public String getObs() {
		return obs;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
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

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	@Override
	public String toString() {
		return "Cliente [cpf_cnpj=" + cpfCnpj + ", nome=" + nome
				+ ", endereco=" + endereco + ", bairro=" + bairro + ", cidade="
				+ cidade + ", estado=" + estado + ", telefone=" + telefone
				+ ", celular=" + celular + ", email=" + email + ", obs=" + obs
				+ "]";
	}
	
		
	
	
}
