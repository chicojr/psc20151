package dados;

import dominio.Cliente;

public interface IClienteDAO {
	public void inserir(Cliente cliente);
	
	public void atualizar(Cliente cliente);
	
	public Cliente consultarCliente(String cpf);
	
}