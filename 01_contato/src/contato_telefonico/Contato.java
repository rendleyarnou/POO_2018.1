package contato_telefonico;

import java.util.ArrayList;
import java.util.List;

public class Contato {
	public String nome;
	public ArrayList<Telefone> telefones;
	//CONSTRUTOR
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
	//ADICIONAR
	public boolean addFone(Telefone telefone) {	
		for (int i = 0; i< telefones.size(); i++) {
			if(telefones.get(i).getFoneId().equals(telefone.getFoneId())) {
				throw new RuntimeException("Erro! " + telefone + " já existe!");
			}
		}
		telefones.add(telefone);
		return true;		
	}
	//REMOVER
	public boolean rmFone(String idFone) {	
		for (int i = 0; i< telefones.size(); i++) {
			if(telefones.get(i).getFoneId().equals(idFone)) {
				telefones.remove(telefones.get(i));
				return true;
			}
		}
		return false;		
	}
	public ArrayList<Telefone> showFone(ArrayList <Telefone> telefones) {
		return telefones;
	}
	//ALTERAR
	public boolean update(String idFone, int numero, String newidFone, int newnumero) {
		for (int i = 0; i< telefones.size(); i++) {
			if(telefones.get(i).getFoneId().equals(idFone) && 
				telefones.get(i).getNumero() == numero) {
				telefones.get(i).setFoneId(newidFone);
				telefones.get(i).setNumero(newnumero);
				return true;
			}
		}
		throw new RuntimeException("Fail: " + idFone + " não existe!");
	}
	
	public String toString() {
		return "" + nome + " " + telefones.toString();
	}
}
