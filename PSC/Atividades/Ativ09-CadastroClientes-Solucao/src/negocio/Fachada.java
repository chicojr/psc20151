package negocio;

import java.util.List;

import negocio.exceptions.CampoObrigatorio;
import negocio.exceptions.ClienteNaoExite;
import dominio.Cliente;
import dominio.ClienteHistorico;

public class Fachada implements IFachada {
	//==================================================
	// Atributos
	//==================================================
	private ClienteController objClienteController;

	//==================================================
	// Construtores
	//==================================================	
	public Fachada(){
		objClienteController = new ClienteController();
	}
	
	//==================================================
	// Métodos
	//==================================================
	@Override
	public void inserirOuAtualizarCliente(Cliente cliente) throws CampoObrigatorio {
		objClienteController.inserirOuAtualizarCliente(cliente);
	}

	@Override
	public void excluirCliente(String cpf) throws CampoObrigatorio, ClienteNaoExite {
		objClienteController.excluirCliente(cpf);		
	}

	@Override
	public List<ClienteHistorico> listarHistoricoCliente(String cpf) throws CampoObrigatorio, ClienteNaoExite {
		return objClienteController.listarHistoricoCliente(cpf);
	}
}