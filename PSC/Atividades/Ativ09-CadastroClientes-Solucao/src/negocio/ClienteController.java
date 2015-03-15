package negocio;

import java.util.List;

import negocio.exceptions.CampoObrigatorio;
import negocio.exceptions.ClienteNaoExite;
import dados.ClienteDAO;
import dados.ClienteHistoricoDAO;
import dados.IClienteDAO;
import dados.IClienteHistoricoDAO;
import dominio.Cliente;
import dominio.ClienteHistorico;
import dominio.Situacao;

public class ClienteController {
	//==================================================
	// Atributos
	//==================================================
	private IClienteDAO clienteDAO;
	private IClienteHistoricoDAO clienteHistoricoDAO;
	
	//==================================================
	// Construtores
	//==================================================
	public ClienteController(){
		clienteDAO = new ClienteDAO();
		clienteHistoricoDAO = new ClienteHistoricoDAO();
	}
	
	//==================================================
	// M�todos
	//==================================================
	public void inserirOuAtualizarCliente(Cliente cliente) throws CampoObrigatorio{
		//Verifica se existem campos n�o informados
		if (cliente.getCpf() == null || cliente.getCpf().trim().equals("")
				|| cliente.getNome() == null || cliente.getNome().trim().equals("")
				|| cliente.getTelefone() == null || cliente.getTelefone().trim().equals("")) {
			throw new CampoObrigatorio("Campo obrigat�rio n�o informado.");
		}
		
		//Altera a situa��o do cliente para ATIVO
		cliente.setSituacao(Situacao.ATIVO);
		
		//Verifica se o cliente j� foi cadastrado
		if (clienteDAO.consultarCliente(cliente.getCpf()) == null) {
			clienteDAO.inserir(cliente);
		}else{
			clienteDAO.atualizar(cliente);
		}
		
		clienteHistoricoDAO.inserir(new ClienteHistorico(cliente));
		
		//Exibe a mensagem da opera��o
		System.out.println("Cliente atualizado com sucesso.");
	}
	
	public void excluirCliente(String cpf) throws CampoObrigatorio, ClienteNaoExite{
		//Verifica se existem campos n�o informados
		if (cpf == null || cpf.trim().equals("")){
			throw new CampoObrigatorio("Campo obrigat�rio n�o informado.");
		}
		
		//Consulta o cliente
		Cliente cliente = clienteDAO.consultarCliente(cpf);
		
		//Verifica se o cliente existe
		if (cliente == null) {
			throw new ClienteNaoExite("Cliente n�o existe");
		}
		
		cliente.setSituacao(Situacao.INATIVO);
		clienteDAO.atualizar(cliente);

		clienteHistoricoDAO.inserir(new ClienteHistorico(cliente));
		
		//Exibe a mensagem da opera��o
		System.out.println("Cliente exclu�do com sucesso.");
	}
	
	public List<ClienteHistorico> listarHistoricoCliente(String cpf) throws CampoObrigatorio, ClienteNaoExite{
		//Verifica se existem campos n�o informados
		if (cpf == null || cpf.trim().equals("")){
			throw new CampoObrigatorio("Campo obrigat�rio n�o informado.");
		}
		
		//Verifica se o cliente existe
		if (clienteDAO.consultarCliente(cpf) == null) {
			throw new ClienteNaoExite("Cliente n�o existe");
		}else{
			return clienteHistoricoDAO.listarHistoricoCliente(cpf);
		}
	}
}