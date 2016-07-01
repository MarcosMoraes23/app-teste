package app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="forma_pgto")
public class FormaPgto {
			
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private Long id;
	
	@Column(name="descricao", nullable=false, length=120)	
	private String descricao;
	
	@Column(name="obs", nullable=true, length=255)	
	private String obs;

	public FormaPgto() {
	}

	public FormaPgto(Long id, String descricao, String obs) {
		this.id = id;
		this.descricao = descricao;
		this.obs = obs;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getObs() {
		return obs;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	@Override
	public String toString() {
		return "FormaPgto [id=" + id + ", descricao=" + descricao + ", obs="
				+ obs + "]";
	}
	
	
	
	
}
