package app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="equipamento")
public class Equipamento {
			
	@Id
	@Column(name="id", nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	
	@Column(name="equipamento", nullable=false, length=60)	
	private String equipamento;
	
	@Column(name="acessorios", nullable=true, length=120)	
	private String acessorios;
	
	@Column(name="numero_serie", nullable=true, length=30)	
	private String numeroSerie;
	
	@Column(name="obs", nullable=true, length=255)	
	private String obs;
	
	@ManyToOne
	@JoinColumn(name = "id_modelo")
	private Modelo modelo;

	public Equipamento() {
	}

	public Equipamento(Long id, String equipamento, String acessorios,
			String numeroSerie, String obs, Modelo modelo) {
		this.id = id;
		this.equipamento = equipamento;
		this.acessorios = acessorios;
		this.numeroSerie = numeroSerie;
		this.obs = obs;
		this.modelo = modelo;
	}

	public Long getId() {
		return id;
	}

	public String getEquipamento() {
		return equipamento;
	}

	public String getAcessorios() {
		return acessorios;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public String getObs() {
		return obs;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}

	public void setAcessorios(String acessorios) {
		this.acessorios = acessorios;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Equipamento [id=" + id + ", equipamento=" + equipamento
				+ ", acessorios=" + acessorios + ", numero_serie="
				+ numeroSerie + ", obs=" + obs + "]";
	}
	
	
	
}
