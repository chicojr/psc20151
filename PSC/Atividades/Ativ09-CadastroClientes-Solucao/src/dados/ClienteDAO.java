package dados;

import java.util.ArrayList;
import java.util.List;

import dominio.Cliente;

public class ClienteDAO implements IClienteDAO {
	// ==================================================
	// Atributos
	// ==================================================
	private List<Cliente> colecao;

	// ==================================================
	// Construtores
	// ==================================================
	public ClienteDAO() {
		colecao = new ArrayList<Cliente>();
	}

	// ==================================================
	// Métodos
	// ==================================================
	@Override
	public void inserir(Cliente cliente) {
		colecao.add(cliente);
	}

	@Override
	public void atualizar(Cliente cliente) {
		int ind = colecao.indexOf(cliente);
		colecao.set(ind, cliente);
	}

	@Override
	public Cliente consultarCliente(String cpf) {
		for (Cliente c : colecao) {
			if (c.getCpf().equals(cpf)) {
				return c;
			}
		}
		return null;
	}

}