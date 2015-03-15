package dados;

import java.util.List;

import dominio.ClienteHistorico;

public interface IClienteHistoricoDAO  {
	public void inserir(ClienteHistorico clienteHistorico);

	public List<ClienteHistorico> listarHistoricoCliente(String cpf);

}
