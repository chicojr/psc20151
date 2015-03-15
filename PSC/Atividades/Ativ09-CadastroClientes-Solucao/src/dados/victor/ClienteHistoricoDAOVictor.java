package dados.victor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dados.IClienteHistoricoDAO;
import dominio.ClienteHistorico;

public class ClienteHistoricoDAOVictor implements IClienteHistoricoDAO {
	private List<ClienteHistorico> historicos;

	public ClienteHistoricoDAOVictor() {
		historicos = new ArrayList<ClienteHistorico>();
	}

	@Override
	public List<ClienteHistorico> listarHistoricoCliente(String cpf) {
		return historicos.stream().filter(c -> c.getCpf().equals(cpf))
				.collect(Collectors.toList());
	}

	@Override
	public void inserir(ClienteHistorico clienteHistorico) {
		historicos.add(clienteHistorico);
	}
}
