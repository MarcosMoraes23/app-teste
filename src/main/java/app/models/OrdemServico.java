package app.models;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ordem_servico")
public class OrdemServico {
			
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Column(name="id", nullable=false)
	private Long id;
	
	@Column(name="numero", nullable=false, unique=true, length=9)	
	private String numero;
	
	@Column(name="valor_total", nullable=false)
	private BigDecimal valorTotal;
	
	@Column(name="data_entrada", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dataEntrada;
	
	@Column(name="data_saida", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date dataSaida;
	
	@Column(name="tipo", nullable=false, length=1)	
	private char tipo;
	
	@Column(name="status", nullable=false, length=1)	
	private char status;
	
	@Column(name="defeito", nullable=false, length=255)	
	private String defeito;
	
	@Column(name="historico", nullable=true, length=255)	
	private String historico;
	
	@ManyToOne		
	@JoinColumn(name="id_usuario")	
	private Usuario id_usuario;
	
	@ManyToOne	
	@JoinColumn(name="id_equipamento")	
	private Equipamento id_equipamento;
	
	@ManyToOne	
	@JoinColumn(name="id_cliente")	
	private Cliente id_cliente;
			
	@ManyToMany
    @JoinTable(name = "servico_ordem_servicos",
    joinColumns = {@JoinColumn(name = "id_ordem_servico")},inverseJoinColumns = {@JoinColumn(name = "id_servicos")})
    private List<Servico> servicos = new ArrayList<Servico>();

	public OrdemServico() {
	}

	public OrdemServico(Long id, String numero, BigDecimal valorTotal,
			Date dataEntrada, Date dataSaida, char tipo, char status,
			String defeito, String historico, Usuario id_usuario,
			Equipamento id_equipamento, Cliente id_cliente,
			List<Servico> servicos) {
		this.id = id;
		this.numero = numero;
		this.valorTotal = valorTotal;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.tipo = tipo;
		this.status = status;
		this.defeito = defeito;
		this.historico = historico;
		this.id_usuario = id_usuario;
		this.id_equipamento = id_equipamento;
		this.id_cliente = id_cliente;
		this.servicos = servicos;
	}

	public Long getId() {
		return id;
	}

	public String getNumero() {
		return numero;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public char getTipo() {
		return tipo;
	}

	public char getStatus() {
		return status;
	}

	public String getDefeito() {
		return defeito;
	}

	public String getHistorico() {
		return historico;
	}

	public Usuario getId_usuario() {
		return id_usuario;
	}

	public Equipamento getId_equipamento() {
		return id_equipamento;
	}

	public Cliente getId_cliente() {
		return id_cliente;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public void setDefeito(String defeito) {
		this.defeito = defeito;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}

	public void setId_equipamento(Equipamento id_equipamento) {
		this.id_equipamento = id_equipamento;
	}

	public void setId_cliente(Cliente id_cliente) {
		this.id_cliente = id_cliente;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	@Override
	public String toString() {
		return "OrdemServico [id=" + id + ", numero=" + numero
				+ ", valorTotal=" + valorTotal + ", dataEntrada=" + dataEntrada
				+ ", dataSaida=" + dataSaida + ", tipo=" + tipo + ", status="
				+ status + ", defeito=" + defeito + ", historico=" + historico
				+ "]";
	}

	
		
}
