package contato_telefônico;

import java.util.ArrayList;
import java.util.List;

public class Contato {
	
	public String nome;
	public List<Telefone> telefones;
	
	public Contato(String nome) {
		this.nome = nome;
		this.telefones =  new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	
	public boolean addFone(Telefone telefone) {
		
		for (int i = 0; i< telefones.size(); i++) {
			if(telefones.get(i).getFoneId().equals(telefone.getFoneId())) {
				return false;
			}
		}
		telefones.add(telefone);
		return true;		
	}
	
	public boolean rmFone(String idFone) {
		
		for (int i = 0; i< telefones.size(); i++) {
			if(telefones.get(i).getFoneId().equals(idFone)) {
				telefones.remove(telefones.get(i));
				return true;
			}
		}
		return false;		
	}
	
	public List<Telefone> showFone(List <Telefone> telefones) {
		return telefones;
	}
	
	public String toString() {
		return "Contato [nome= " + nome + ", telefones= " + telefones + "]";
	}

}
