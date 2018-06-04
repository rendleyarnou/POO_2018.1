package clinica_veterinaria;

public class ServicoClinica {
	private static int nextIdAni = 0;
	private static int nextIdSer = 0;
	private static int nextIdVen = 0;

	private Repository<Servico> rSer;
	private Repository<Animal> rAni;
	private Repository<Cliente> rCli;
	private Repository<Venda> rVen;
	private float saldoDeVendas;

	public ServicoClinica() {
		this.rSer = new Repository<Servico>("Serviços");
		this.rAni = new Repository<Animal>("Animais");
		this.rCli = new Repository<Cliente>("Clientes");
		this.rVen = new Repository<Venda>("Vendas");
		this.saldoDeVendas = 0;
	}

	public float getSaldoDeVendas() {
		return saldoDeVendas;
	}

	public void addCli(String nome, String idCli) {
		if (idCli == null) {
			throw new RuntimeException("Fail: " + idCli + " nulo.");
		}
		for (int i = 0; i < rCli.getAll().size(); i++) {
			if (rCli.getAll().get(i).getIdCli().equals(idCli)) {
				throw new RuntimeException("Fail: cliente " + idCli + " já exite.");
			}
		}
		rCli.add(new Cliente(nome, idCli));
	}

	public void addAni(String dono, String nome, String especie) {
		if (dono == null) {
			throw new RuntimeException("Fail: dono do animal nulo.");
		}
		if (nome == null) {
			throw new RuntimeException("Fail: nome do animal nulo.");
		}
		if (especie == null) {
			throw new RuntimeException("Fail: especie do animal nula.");
		}
		Animal ani = new Animal(nextIdAni += 1, nome, especie);
		rAni.add(ani);
		getrCli(dono).addAni(ani);
		;
	}

	public void addSer(String nome, float preco) {
		if (preco < 0) {
			throw new RuntimeException("Fail: preco menor que zero.");
		}
		rSer.add(new Servico(nextIdSer += 1, nome, preco));
	}

	public void Vender(String idCli, String nome, int idSer) {
		if (idCli == null) {
			throw new RuntimeException("Fail: idCli nulo.");
		}
		if (nome == null) {
			throw new RuntimeException("fail: nome do animal nulo.");
		}
		rVen.add(new Venda(nextIdVen += 1, idCli, nome, getrSer(idSer).nome));
		this.saldoDeVendas += getrSer(idSer).valor;
	}

	public String getrAllSer() {
		String saida = "";
		for (Servico ser : rSer.getAll()) {
			saida += ser.toString() + "\n";
		}
		return saida;
	}

	public String getrAllAni() {
		String saida = "";
		for (Animal ani : rAni.getAll()) {
			saida += ani.toString() + "\n";
		}
		return saida;
	}

	public String getAllrCli() {
		String saida = "";
		for (Cliente cli : rCli.getAll()) {
			saida += cli.toString() + "\n";
		}
		return saida;
	}
	
	public String getAllrVen() {
		String saida = "";
		for (Venda ven : rVen.getAll()) {
			saida += ven.idVen + " " + ven.idCli + " " +  ven.idAni + " " + ven.idSer + "\n";
		}
		return saida;
	}

	public Servico getrSer(int idSer) {
		for (Servico ser : rSer.getAll()) {
			if (ser.idSer == idSer) {
				return ser;
			}
		}
		throw new RuntimeException("Fail: " + idSer + " não existe.");
	}

	public Animal getrAni(int idAni) {
		for (Animal ani : rAni.getAll()) {
			if (ani.idAni == idAni) {
				return ani;
			}
		}
		throw new RuntimeException("Fail: " + idAni + " não existe.");
	}

	public Cliente getrCli(String idCli) {
		for (Cliente cli : rCli.getAll()) {
			if (cli.getIdCli().equals(idCli)) {
				return cli;
			}
		}
		throw new RuntimeException("Fail: " + idCli + " não existe.");
	}
}
