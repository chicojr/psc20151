package dominio;

import java.util.Date;

import util.Datas;

public class ClienteHistorico extends Cliente {
	//==================================================
	// Atributos
	//==================================================
	private Date dataAlteracao;
	
	//==================================================
	// Construtores
	//==================================================
	public ClienteHistorico(Cliente cliente) {
		super(cliente.getNome(), cliente.getCpf(), cliente.getTelefone(), cliente.getSituacao());
		dataAlteracao = new Date();
	}

	//==================================================
	// Métodos
	//==================================================
	@Override
	public String toString() {
		return "ClienteHistorico [cliente=" + super.toString() + ", dataAlteracao="
		+ Datas.formatarData(dataAlteracao, "EEE, d MMM yyyy HH:mm:ss") + "]";
	}
	
	//==================================================
	// Gets e Sets
	//==================================================
	public Date getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
}