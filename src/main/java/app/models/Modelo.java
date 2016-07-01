package app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "modelo")
public class Modelo {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private Long id;
	
	@Column(name="descricao", nullable=false, length=60)	
	private String descricao;
	
	@Column(name="marca", nullable=false, length=60)	
	private String marca;
	
	public Modelo() {
	}
	
	public Modelo(Long id, String descricao, String marca) {
		this.id = id;
		this.descricao = descricao;
		this.marca = marca;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Modelo [descricao=" + descricao + ", marca=" + marca + "]";
	}
	
	
}
