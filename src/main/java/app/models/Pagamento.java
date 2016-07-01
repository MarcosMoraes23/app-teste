package app.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="pgto")
public class Pagamento {
		
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false)	
	private Long id;
	
	@Column(name="data_pgto", nullable=false, unique=true)	
	@Temporal(TemporalType.DATE)	
	private Date dataPgto;
	
	@Column(name="parcela", nullable=false)	
	private int parcela;
	
	@Column(name="valor", nullable=false, precision=15, scale=2)	
	private BigDecimal valor;
	
	@Column(name="descricao_pgto", nullable=false, length=255)	
	private String descricaoPgto;
	
	@ManyToOne	
	@JoinColumn(name="id_forma_pgto")	
	private FormaPgto formaPgto;

	@ManyToOne	
	@JoinColumn(name="id_ordem_servico")
	private OrdemServico ordemServico;
	
	public Pagamento() {
	}

	public Pagamento(Long id, Date dataPgto, int parcela, BigDecimal valor,
			String descricaoPgto, FormaPgto formaPgto, OrdemServico ordemServico) {
		this.id = id;
		this.dataPgto = dataPgto;
		this.parcela = parcela;
		this.valor = valor;
		this.descricaoPgto = descricaoPgto;
		this.formaPgto = formaPgto;
		this.ordemServico = ordemServico;
	}

	public Long getId() {
		return id;
	}

	public Date getDataPgto() {
		return dataPgto;
	}

	public int getParcela() {
		return parcela;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public String getDescricaoPgto() {
		return descricaoPgto;
	}

	public FormaPgto getFormaPgto() {
		return formaPgto;
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDataPgto(Date dataPgto) {
		this.dataPgto = dataPgto;
	}

	public void setParcela(int parcela) {
		this.parcela = parcela;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public void setDescricaoPgto(String descricaoPgto) {
		this.descricaoPgto = descricaoPgto;
	}

	public void setFormaPgto(FormaPgto formaPgto) {
		this.formaPgto = formaPgto;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	@Override
	public String toString() {
		return "Pagamento [id=" + id + ", dataPgto=" + dataPgto + ", parcela="
				+ parcela + ", valor=" + valor + ", descricaoPgto="
				+ descricaoPgto + ", formaPgto=" + formaPgto
				+ ", ordemServico=" + ordemServico + "]";
	}

				
}
