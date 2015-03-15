package dados.victor;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import dados.IClienteDAO;
import dominio.Cliente;

public class ClienteDAOVictor implements IClienteDAO {
	// ==================================================
	// Atributos
	// ==================================================
	private List<Cliente> objClientes;

	// ==================================================
	// Construtores
	// ==================================================
	public ClienteDAOVictor() {
		objClientes = new ArrayList<Cliente>();
	}

	// ==================================================
	// Métodos
	// ==================================================
	@Override
	public void inserir(Cliente cliente) {
		objClientes.add(cliente);
	}

	@Override
	public void atualizar(Cliente cliente) {
		objClientes.remove(cliente);
		objClientes.add(cliente);
	}

	@Override
	public Cliente consultarCliente(String cpf) {
		try {
			return objClientes.stream().filter(c -> c.getCpf().equals(cpf))
					.findFirst().get();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

}