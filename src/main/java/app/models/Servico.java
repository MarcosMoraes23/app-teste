package app.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table(name="servico")
	public class Servico {
			
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="id", nullable=false)			
		private Long id;
		
		@Column(name="descricao", nullable=false, length=255)	
		private String descricao;
		
		@Column(name="valor_servico", nullable=false)	
		private BigDecimal valorServico;

		public Servico() {
		}

		public Servico(Long id, String descricao, BigDecimal valorServico) {
			this.id = id;
			this.descricao = descricao;
			this.valorServico = valorServico;
		}

		public Long getId() {
			return id;
		}

		public String getDescricao() {
			return descricao;
		}

		public BigDecimal getValorServico() {
			return valorServico;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public void setValorServico(BigDecimal valorServico) {
			this.valorServico = valorServico;
		}

		@Override
		public String toString() {
			return "Servico [id=" + id + ", descricao=" + descricao
					+ ", valorServico=" + valorServico + "]";
		}
		
		
		
		
		
	}

