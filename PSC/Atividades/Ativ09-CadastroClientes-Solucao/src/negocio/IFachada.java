package negocio;

import java.util.List;

import negocio.exceptions.CampoObrigatorio;
import negocio.exceptions.ClienteNaoExite;
import dominio.Cliente;
import dominio.ClienteHistorico;

public interface IFachada {
	public void inserirOuAtualizarCliente(Cliente cliente) throws CampoObrigatorio;
	
	public void excluirCliente(String cpf) throws CampoObrigatorio, ClienteNaoExite;
	
	public List<ClienteHistorico> listarHistoricoCliente(String cpf) throws CampoObrigatorio, ClienteNaoExite;
}