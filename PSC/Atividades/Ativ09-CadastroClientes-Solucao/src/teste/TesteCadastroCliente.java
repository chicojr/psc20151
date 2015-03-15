package teste;

import java.util.List;

import negocio.Fachada;
import negocio.IFachada;
import negocio.exceptions.CampoObrigatorio;
import negocio.exceptions.ClienteNaoExite;
import dominio.Cliente;
import dominio.ClienteHistorico;

public class TesteCadastroCliente {

	// Atribuir uma instancia da fachada do seu sistema
	private static IFachada fachada = new Fachada();
	
	public static void main(String[] args) {

		System.out.println("Inserindo: ");
		inserirOuAtualizarCliente("Amaro", "2330132", "8888-2121");
		
		System.out.println("Atualizando: ");
		inserirOuAtualizarCliente("Amaro Lopes", "2330132", "8888-1111");
		
		System.out.println("Inserindo: ");
		inserirOuAtualizarCliente("Ana Carla", "556677", "9081-0202");

		System.out.println("Inserindo: ");
		inserirOuAtualizarCliente("Keila Gomes da Silva", "230091", "8789-1022");

		System.out.println("Atualizando: ");
		inserirOuAtualizarCliente("Amaro Lopes Borba", "2330132", "8888-1111");

		System.out.println("Excluindo: ");
		excluirCliente("556677");

		System.out.println("Excluindo: ");
		excluirCliente("123123");
		
		System.out.println("Exibir histórico de atualizações: ");
		imprimirHistoricoCliente("2330132");

		System.out.println("Exibir histórico de atualizações: ");
		imprimirHistoricoCliente("556677");

	}

	private static void inserirOuAtualizarCliente(String nome, String cpf, String telefone) {
		try {
			Cliente c1 = new Cliente(nome, cpf, telefone);
			fachada.inserirOuAtualizarCliente(c1);
		} catch (CampoObrigatorio e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void excluirCliente(String cpf){
		
		try {
			fachada.excluirCliente(cpf);
		} catch (CampoObrigatorio | ClienteNaoExite e) {
			System.out.println(e.getMessage());
		}		
	}
	
	private static void imprimirHistoricoCliente(String cpf){
		List<ClienteHistorico> lista;
		try {
			lista = fachada.listarHistoricoCliente(cpf);
			
			for (ClienteHistorico clienteHistorico : lista) {
				System.out.println(clienteHistorico);
			}
		} catch (CampoObrigatorio | ClienteNaoExite e) {
			System.out.println(e.getMessage());
		}		
	}
}
