package agencia_bancaria;

public class Agencia {
	private Repositorio<Cliente> clientes;
	private Cliente user;

	// CONSTRUTOR
	public Agencia() {
		clientes = new Repositorio<Cliente>("Clientes");
	}
	
	public void encer(String idCli, int numero) {
		for (Cliente cli : clientes.getAll()) {
			if(cli.getIdCliente().equals(idCli)) {
				for (Conta conta : cli.getContas().getAll()) {
					if(conta.getNumero() == numero) {
						cli.encerrarConta(numero);
					}
				}
			}
		}
	}
	
	public Conta getContaCli(int numero) {
		for (Cliente cli : clientes.getAll()) {
			for (Conta conta : cli.getContas().getAll()) {
				if(conta.getNumero() == numero) {
					return conta;
				}
			}
		}
		throw new RuntimeException("Fail: conta " + numero + " não existe.");
	}
	
	public Conta getConta(int numero) {
		for (Conta conta : getUser().getContas().getAll()) {
			if(conta.getNumero() == numero) {
				return conta;
			}
		}
		throw new RuntimeException("Fail: conta " + numero + " não existe.");
	}
	
	// ADICIONAR
	public boolean addCliente(String idCliente) {
		for (Cliente c : clientes.getAll()) {
			if (c.getIdCliente().equals(idCliente)) {
				throw new RuntimeException("Fail: " + idCliente + " já cadastrado.");
			}
		}
		this.clientes.add(new Cliente(idCliente));
		return true;
	}

	// ABRIR NOVA CONTA
	public boolean abrirNovaConta(String idCliente) {
		for (Cliente cli : clientes.getAll()) {
			if (cli.getIdCliente().equals(idCliente)) {
				cli.addConta(new Conta(Conta.ultIdConta+=1));
				return true;
			}
		}
		throw new RuntimeException("Fail: " + idCliente + " não existe.");
	}

	public Cliente getCliente(String idCliente) {
		for (Cliente cli : clientes.getAll()) {
			if (cli.getIdCliente().equals(idCliente)) {
				return cli;
			}
		}
		throw new RuntimeException("Fail: " + idCliente + " não existe.");
	}

	public Repositorio<Cliente> getClientes() {
		return clientes;
	}

	public String toString() {
		String saida = "";
		for (Cliente cli : clientes.getAll()) {
			saida += "Cliente: " + cli.getIdCliente() + "\n";
		}
		return saida;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////
	// LOGIN
	public boolean login(String username) {
		if (user != null) {
			throw new RuntimeException("Fail: já existe alguém logado.");
		}
		if (username.equals(null)) {
			throw new RuntimeException("Fail: é nulo.");
		}
		for (Cliente cli : clientes.getAll()) {
			if(cli.getIdCliente().equals(username)) {
				this.user = cli;
				return true;
			}else {
				throw new RuntimeException("Fail: usuário não existe.");
			}
		}
		return false;
	}
	// LOGOUT
	public void logout() {
		if (user == null)
			throw new RuntimeException("Fail: ninguém logado.");
		user = null;
	}
	// GETUSER
	public Cliente getUser() {
		if (user == null)
			throw new RuntimeException("Fail: ninguém logado.");
		return user;
	}
}
