package dados;

import java.util.ArrayList;
import java.util.List;

import dominio.ClienteHistorico;

public class ClienteHistoricoDAO implements IClienteHistoricoDAO {
	private List<ClienteHistorico> colecao;

	public ClienteHistoricoDAO() {
		colecao = new ArrayList<ClienteHistorico>();
	}

	@Override
	public List<ClienteHistorico> listarHistoricoCliente(String cpf) {
		List<ClienteHistorico> retorno = new ArrayList<ClienteHistorico>();
		for (ClienteHistorico ch : colecao){
			if (ch.getCpf().equals(cpf)){
				retorno.add(ch);
			}
		}
		return retorno;
	}

	@Override
	public void inserir(ClienteHistorico clienteHistorico) {
		colecao.add(clienteHistorico);
	}
}
